package ftq.ink.activation.dao;

import ftq.ink.activation.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
