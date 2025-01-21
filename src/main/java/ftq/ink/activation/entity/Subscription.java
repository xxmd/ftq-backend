package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class Subscription extends BaseEntity {
    // 套餐名称
    public String name;
    // 套餐价格
    public Double price;
    // 套餐激活天数
    public int activationDays;
}
