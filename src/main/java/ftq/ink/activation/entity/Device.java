package ftq.ink.activation.entity;


import javax.persistence.Entity;

@Entity
public class Device extends BaseEntity {
    // 设备安卓 id
    public String androidId;
    // 设备模型
    public String model;
    // 设备制造商
    public String manufacturer;
    // apiLevel
    public int apiLevel;
}
