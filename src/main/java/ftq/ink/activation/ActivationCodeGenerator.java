package ftq.ink.activation;

import ftq.ink.activation.entity.ActivationCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ActivationCodeGenerator {
    public static List<ActivationCode> batchGeneActivationCode(int subscriptionId, int count) {
        List<ActivationCode> codeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ActivationCode activationCode = geneActivationCode(subscriptionId);
            codeList.add(activationCode);
        }
        return codeList;
    }

    public static ActivationCode geneActivationCode(int subscriptionId) {
        ActivationCode activationCode = new ActivationCode();
        activationCode.subscriptionId = subscriptionId;
        activationCode.content = UUID.randomUUID().toString().replace("-", "");
        return activationCode;
    }
}