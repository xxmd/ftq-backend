package ftq.ink.activation.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @CreationTimestamp
    @Column
    public Date createTime;

    @UpdateTimestamp
    public Date updateTime;
}
