package ftq.ink.activation.dao;

import ftq.ink.activation.entity.PaymentPlatform;
import ftq.ink.activation.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentPlatformRepository extends JpaRepository<PaymentPlatform, Long> {
    @Query("SELECT pp FROM PaymentPlatform pp WHERE pp.id IN (SELECT stpp.paymentPlatformId FROM SubscriptionToPaymentPlatform stpp WHERE stpp.subscriptionId = :subscriptionId)")
    List<PaymentPlatform> findAllBySubscriptionId(@Param("subscriptionId") Long subscriptionId);
}
