package br.com.zupacademy.carlivan.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ValidaEstadoPaisValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaEstadoPais {

    String message() default "Estado repetido para esse país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

