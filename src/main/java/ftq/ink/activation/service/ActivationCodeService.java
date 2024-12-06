package ftq.ink.activation.service;

import ftq.ink.activation.dao.ActivationCodeRepository;
import ftq.ink.activation.dto.ActivationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivationCodeService {
    @Autowired
    private ActivationCodeRepository activationCodeRepository;

    public void activate(ActivationDto activationDto) {
    }
}
