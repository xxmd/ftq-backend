package ftq.ink.activation.anno;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SubscriptionIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSubscriptionId {
    String message() default "subscriptionId does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
