package com.tech.kj.custom.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueValueValidator.class)
@Documented()
public @interface UniqueValue {
    String message() default "{err.already.exist}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
