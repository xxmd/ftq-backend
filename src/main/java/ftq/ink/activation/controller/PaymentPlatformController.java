package ftq.ink.activation.controller;

import ftq.ink.activation.dao.PaymentPlatformRepository;
import ftq.ink.activation.dao.SubscriptionRepository;
import ftq.ink.activation.entity.ApiResponse;
import ftq.ink.activation.entity.PaymentPlatform;
import ftq.ink.activation.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paymentPlatform")
public class PaymentPlatformController {

    @Autowired
    private PaymentPlatformRepository paymentPlatformRepository;


    /**
     * 根据订阅id获取对应的付款平台列表
     *
     * @return
     */
    @GetMapping("/findAllBySubscriptionId")
    public ApiResponse findAllBySubscriptionId(@RequestParam Long subscriptionId) {
        List<PaymentPlatform> platformList = paymentPlatformRepository.findAllBySubscriptionId(subscriptionId);
        return ApiResponse.success(platformList);
    }
}
