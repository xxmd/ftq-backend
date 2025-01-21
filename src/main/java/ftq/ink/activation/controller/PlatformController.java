package ftq.ink.activation.controller;

import ftq.ink.activation.dao.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    private PlatformRepository platformRepository;
}
