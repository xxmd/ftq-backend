package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class SubscriptionToPaymentPlatform extends BaseEntity{
    private Long subscriptionId;
    private Long paymentPlatformId;
}