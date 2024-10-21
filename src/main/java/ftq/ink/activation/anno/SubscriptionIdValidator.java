package ftq.ink.activation.anno;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ftq.ink.activation.dao.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionIdValidator implements ConstraintValidator<ValidSubscriptionId, Integer> {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public boolean isValid(Integer subscriptionId, ConstraintValidatorContext context) {
        // 校验 subscriptionId 是否存在
        return subscriptionRepository != null && subscriptionRepository.existsById(subscriptionId);
    }
}
