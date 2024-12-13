package ftq.ink.activation.dao;

import ftq.ink.activation.entity.Sku;
import ftq.ink.activation.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuRepository extends JpaRepository<Sku, Long> {

}
