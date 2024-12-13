package ftq.ink.activation.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class ActivationCode extends BaseEntity {

    public enum ActivationCodeStatus {
        CREATED, EXPORTED, ACTIVATED
    }

    public String content;
    @Enumerated(EnumType.STRING)
    public ActivationCodeStatus status = ActivationCodeStatus.CREATED;
    public Long subscriptionId;
    public Date exportTime;
    public Date activateTime;
    public Long deviceId;
}
