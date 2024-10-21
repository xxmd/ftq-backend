package ftq.ink.activation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    public String deviceInfo;
    public Integer subscriptionId;
    public Integer activationCodeId;
}
