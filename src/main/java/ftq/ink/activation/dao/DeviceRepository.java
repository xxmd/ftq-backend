package ftq.ink.activation.dao;

import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.entity.Device;
import ftq.ink.activation.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    ActivationCode findByAndroidId(String androidId);
}
