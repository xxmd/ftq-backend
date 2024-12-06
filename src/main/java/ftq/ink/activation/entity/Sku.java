package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class Sku extends BaseEntity {
    public Integer platformId;
    public Integer subscriptionId;
    public String link;
    public PaymentPlatform platform;
}
