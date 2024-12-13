package ftq.ink.activation.dao;

import ftq.ink.activation.entity.ActivationCode;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivationCodeRepository extends JpaRepository<ActivationCode, Long> {
    ActivationCode findByContent(String content);

    @Query("SELECT code FROM ActivationCode code WHERE code.subscriptionId = :subscriptionId AND code.status = :status ORDER BY code.createTime ASC")
    List<ActivationCode> findCreatedCode(@Param("subscriptionId") Long subscriptionId, @Param("status") ActivationCode.ActivationCodeStatus status, Pageable pageable);
}
