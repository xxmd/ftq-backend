package ftq.ink.activation.service;

import ftq.ink.activation.ActivationCodeGenerator;
import ftq.ink.activation.dao.ActivationCodeRepository;
import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.dto.ActivationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActivationCodeService {
    @Autowired
    private ActivationCodeRepository activationCodeRepository;

    public void activate(ActivationDto activationDto) {
    }
}
