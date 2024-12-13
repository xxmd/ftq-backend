package ftq.ink.activation.controller;

import ftq.ink.activation.dao.SubscriptionRepository;
import ftq.ink.activation.entity.ApiResponse;
import ftq.ink.activation.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;


    /**
     * 批量生成激活码
     *
     * @return
     */
    @GetMapping("/findAll")
    public ApiResponse findAll() {
        List<Subscription> subscriptionList = subscriptionRepository.findAll();
        subscriptionList = subscriptionList.stream().sorted(Comparator.comparing(it -> it.price)).collect(Collectors.toList());
        return ApiResponse.success(subscriptionList);
    }
}
