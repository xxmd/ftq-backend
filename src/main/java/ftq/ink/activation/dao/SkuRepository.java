package ftq.ink.activation.dao;

import ftq.ink.activation.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkuRepository extends JpaRepository<Sku, Long> {
    List<Sku> findAllBySubscriptionId(@Param("subscriptionId") Long subscriptionId);
}
