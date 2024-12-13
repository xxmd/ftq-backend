package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class Sku extends BaseEntity {
    public Long platformId; // 所属平台id
    public Long subscriptionId; // 所属订阅套餐id
    public String link; // 链接
//    public PaymentPlatform platform; //
}
