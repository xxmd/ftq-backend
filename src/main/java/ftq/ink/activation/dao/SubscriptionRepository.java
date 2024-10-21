package ftq.ink.activation.dao;

import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
