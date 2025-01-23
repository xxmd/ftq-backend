package ftq.ink.activation.dto;

import ftq.ink.activation.anno.ValidSubscriptionId;
import ftq.ink.activation.entity.Device;

import javax.persistence.OneToOne;

public class ActivationDto {
    public Long activationCodeId;
    @ValidSubscriptionId
    public Long subscriptionId; // 套餐id
    public int geneCount; // 生成数量
    public String content; // 激活码内容
    public Device device; // 设备信息
    public int exportLimit = 100; // 导出数量限制
}
