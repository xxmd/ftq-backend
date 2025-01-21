package ftq.ink.activation.entity;

import javax.persistence.Entity;

@Entity
public class Platform extends BaseEntity {
    // 平台名称
    public String name;
    // 平台图标链接
    public String iconUrl;
    // 平台应用包名
    public String packageName;
}
