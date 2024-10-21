package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class Subscription extends BaseEntity {
    public String name;
    public Double price;
    public int activationDays;
}
