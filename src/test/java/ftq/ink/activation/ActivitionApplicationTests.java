package ftq.ink.activation;

import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.util.ActivationCodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ActivationApplicationTests {

	@Test
	void testActivationCodeGenerator() {
		List<ActivationCode> codeList = ActivationCodeGenerator.batchGeneActivationCode(1, 3);
		codeList.stream().forEach(it -> System.out.println(it.content));
	}

}
