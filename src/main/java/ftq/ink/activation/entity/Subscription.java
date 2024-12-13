package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class Subscription extends BaseEntity {
    public String name; // 套餐名称
    public Double price; // 套餐价格
    public int activationDays; // 套餐激活天数
}
