package ftq.ink.activation.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class ActivationRecord extends BaseEntity {
    public Device device;
    public Integer subscriptionId;
    public Integer activationCodeId;
}
