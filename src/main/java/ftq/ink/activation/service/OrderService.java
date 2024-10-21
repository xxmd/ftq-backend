package ftq.ink.activation.service;

import ftq.ink.activation.dao.OrderRepository;
import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void save(ActivationCode activationCode, String deviceInfo) {
        Order order = new Order();
        order.deviceInfo = deviceInfo;
        order.subscriptionId = activationCode.subscriptionId;
        order.activationCodeId = activationCode.id;
        orderRepository.save(order);
    }
}
