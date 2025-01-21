package ftq.ink.activation.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * 激活码
 */
@Entity
public class ActivationCode extends BaseEntity {
    // 激活码状态枚举
    public enum ActivationCodeStatus {
        CREATED, EXPORTED, ACTIVATED
    }

    // 激活码内容
    public String content;
    // 激活码状态
    @Enumerated(EnumType.STRING)
    public ActivationCodeStatus status = ActivationCodeStatus.CREATED;
    // 所属套餐id
    public Long subscriptionId;
    // 导出时间
    public Date exportTime;
    // 激活时间
    public Date activateTime;
    // 激活设备id
    public Long deviceId;
}
