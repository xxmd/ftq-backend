package ftq.ink.activation.entity;

import javax.persistence.*;

@Entity
public class Sku extends BaseEntity {
    @Column(name = "platform_id", insertable = false, updatable = false)
    // 所属平台 id
    private Long platformId;
    // 所属订阅套餐 id
    public Long subscriptionId;
    // sku 商品链接
    public String link;
    @OneToOne(fetch = FetchType.EAGER)
    // 关联的平台实体类
    public Platform platform;
    public Boolean enable;
}
