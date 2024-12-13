package ftq.ink.activation.controller;

import ftq.ink.activation.dao.SkuRepository;
import ftq.ink.activation.entity.ApiResponse;
import ftq.ink.activation.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuRepository skuRepository;


    /**
     * 批量生成激活码
     *
     * @return
     */
    @PostMapping("/findAllByExample")
    public ApiResponse findAllByExample(@RequestBody Sku sku) {
        Example<Sku> example = Example.of(sku);
        Optional<Sku> skuDao = skuRepository.findOne(example);
        if (skuDao.isPresent()) {
            return ApiResponse.success(skuDao.get());
        } else {
            return ApiResponse.error("sku不存在");
        }
    }
}
