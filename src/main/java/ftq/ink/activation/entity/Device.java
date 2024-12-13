package ftq.ink.activation.entity;


import javax.persistence.Entity;

@Entity
public class Device extends BaseEntity {
    public String androidId;
    public String model;
    public String manufacturer;
    public int apiLevel;
}
