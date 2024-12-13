package ftq.ink.activation.controller;

import ftq.ink.activation.entity.ApiResponse;
import ftq.ink.activation.util.ActivationCodeGenerator;
import ftq.ink.activation.dao.ActivationCodeRepository;
import ftq.ink.activation.dao.SubscriptionRepository;
import ftq.ink.activation.dto.ActivationDto;
import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.service.ActivationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    /**
     * 批量生成激活码
     *
     * @return
     */
    @PostMapping("/batchGene")
    @Transactional
    public ApiResponse batchGene(@Valid @RequestBody ActivationDto activationDto) {
        List<ActivationCode> codeList = ActivationCodeGenerator.batchGeneActivationCode(activationDto.subscriptionId, activationDto.geneCount);
        activationCodeRepository.saveAll(codeList);
        return ApiResponse.success("插入成功");
    }

    @GetMapping("/findByContent")
    public ApiResponse findByContent(@RequestParam String codeContent) {
        ActivationCode daoCode = activationCodeRepository.findByContent(codeContent);
        if (daoCode == null) {
            return ApiResponse.error(String.format("激活码: %s 不存在", codeContent));
        }
        return ApiResponse.success(daoCode);
    }

    @PostMapping("/activate")
    @Transactional
    public ApiResponse activate(@RequestBody ActivationDto activationDto) {
        Optional<ActivationCode> daoCode = activationCodeRepository.findById(activationDto.activationCodeId);
        if (daoCode.isPresent()) {
            if (daoCode.get().status == ActivationCode.ActivationCodeStatus.ACTIVATED) {
                return ApiResponse.error("激活码已被使用");
            } else {
                activationCodeService.activate(daoCode.get(), activationDto.device);
                return ApiResponse.success("激活成功");
            }
        } else {
            return ApiResponse.error(String.format("激活码: %s 不存在", activationDto.content));
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


    @GetMapping("/findOne")
    public Object findOne(@RequestBody ActivationCode activationCode) {
        Example<ActivationCode> example = Example.of(activationCode);
        Optional<ActivationCode> daoCode = activationCodeRepository.findOne(example);
        if (daoCode.isPresent()) {
            return daoCode;
        } else {
            return String.format("激活码: %s 不存在", activationCode.content);
        }
    }
}
