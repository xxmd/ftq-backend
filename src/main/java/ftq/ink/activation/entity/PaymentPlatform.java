package ftq.ink.activation.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class PaymentPlatform extends BaseEntity {
    public String name;
    public String iconUrl;
    public List<Sku> skuList;
}
