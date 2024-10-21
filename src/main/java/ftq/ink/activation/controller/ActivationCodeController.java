package ftq.ink.activation.controller;

import ftq.ink.activation.ActivationCodeGenerator;
import ftq.ink.activation.dao.ActivationCodeRepository;
import ftq.ink.activation.dao.SubscriptionRepository;
import ftq.ink.activation.dto.ActivationDto;
import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.service.ActivationCodeService;
import ftq.ink.activation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/activationCode")
public class ActivationCodeController {
    @Autowired
    private ActivationCodeService activationCodeService;
    @Autowired
    private ActivationCodeRepository activationCodeRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private OrderService orderService;

    /**
     * 批量生成激活码
     *
     * @return
     */
    @PostMapping("/batchGene")
    @Transactional
    public String batchGene(@Valid @RequestBody ActivationDto activationDto) {
        List<ActivationCode> codeList = ActivationCodeGenerator.batchGeneActivationCode(activationDto.subscriptionId, activationDto.geneCount);
        activationCodeRepository.saveAll(codeList);
        return "插入成功";
    }

    @GetMapping("/findByContent")
    public Object findByContent(@RequestParam String codeContent) {
        ActivationCode daoCode = activationCodeRepository.findByContent(codeContent);
        if (daoCode == null) {
            return String.format("激活码: %s 不存在", codeContent);
        }
        return daoCode;
    }

    @PostMapping("/activate")
    @Transactional
    public String activate(@RequestBody ActivationDto activationDto) {
        ActivationCode daoCode = activationCodeRepository.findByContent(activationDto.content);
        if (daoCode != null) {
            if (daoCode.status == ActivationCode.ActivationCodeStatus.ACTIVATED) {
                return "激活码已激活";
            } else {
                daoCode.status = ActivationCode.ActivationCodeStatus.ACTIVATED;
                daoCode.activateTime = new Date();
                activationCodeRepository.save(daoCode);
                orderService.save(daoCode, activationDto.deviceInfo);
                return "激活成功";
            }
        } else {
            return String.format("激活码: %s 不存在", activationDto.content);
        }
    }

    @PostMapping("/export")
    @Transactional
    public String export(@Valid @RequestBody ActivationDto activationDto) {
        Pageable pageable = PageRequest.of(0, activationDto.exportLimit); // 页码从 0 开始，设置返回的数量
        List<ActivationCode> codeList = activationCodeRepository.findCreatedCode(activationDto.subscriptionId, ActivationCode.ActivationCodeStatus.CREATED, pageable);
        for (ActivationCode activationCode : codeList) {
            activationCode.status = ActivationCode.ActivationCodeStatus.EXPORTED;
            activationCode.exportTime = new Date();
        }
        activationCodeRepository.saveAll(codeList);
        return codeList.stream().map(it -> it.content).collect(Collectors.joining(","));
    }

}
