package ftq.ink.activation.util;

import ftq.ink.activation.entity.ActivationCode;
import ftq.ink.activation.entity.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ActivationCodeGenerator {
    public static List<ActivationCode> batchGeneActivationCode(Long subscriptionId, int count) {
        List<ActivationCode> codeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ActivationCode activationCode = geneActivationCode(subscriptionId);
            codeList.add(activationCode);
        }
        return codeList;
    }

    public static ActivationCode geneActivationCode(Long subscriptionId) {
        ActivationCode activationCode = new ActivationCode();
        Subscription subscription = new Subscription();
        subscription.id = subscriptionId;
        activationCode.subscription = subscription;
        activationCode.content = UUID.randomUUID().toString();
        return activationCode;
    }
}
