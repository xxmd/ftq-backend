package ftq.ink.activation.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Subscription extends BaseEntity {
    public String name;
    public Double price;
    public int activationDays;
//    @OneToMany(targetEntity = PaymentPlatform.class)
//    @JoinColumn(name = "suc")
//    public List<PaymentPlatform> platformList;
}
