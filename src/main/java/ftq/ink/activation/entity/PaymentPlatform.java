package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class PaymentPlatform extends BaseEntity {
    public String name;
    public String iconUrl;
//    @Transactional
//    public List<Sku> skuList;
}
