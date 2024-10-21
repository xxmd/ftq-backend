package ftq.ink.activation.dto;

import ftq.ink.activation.anno.ValidSubscriptionId;

public class ActivationDto {
    @ValidSubscriptionId
    public int subscriptionId; // 套餐id
    public int geneCount; // 生成数量
    public String content; // 激活码内容
    public String deviceInfo; // 设备信息
    public int exportLimit = 100; // 导出数量限制
}
