package ftq.ink.activation.service;

import ftq.ink.activation.dao.ActivationCodeRepository;
import ftq.ink.activation.dao.DeviceRepository;
import ftq.ink.activation.dto.ActivationDto;
import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivationCodeService {
    @Autowired
    private ActivationCodeRepository activationCodeRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public void activate(ActivationCode activationCode) {
        activationCode.status = ActivationCode.ActivationCodeStatus.ACTIVATED;
        activationCode.activateTime = new Date();
        activationCodeRepository.save(activationCode);
    }
}
