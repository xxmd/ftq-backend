package ftq.ink.activation.controller;

import ftq.ink.activation.dao.SkuRepository;
import ftq.ink.activation.entity.ApiResponse;
import ftq.ink.activation.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuRepository skuRepository;

    /**
     * 通过订阅 id 获取符合条件的 sku 集合
     *
     * @return
     */
    @GetMapping("/findAllBySubscriptionId")
    public ApiResponse findAllBySubscriptionId(@RequestParam Long subscriptionId) {
        List<Sku> skuList = skuRepository.findAllBySubscriptionId(subscriptionId);
        return ApiResponse.success(skuList);
    }
}
