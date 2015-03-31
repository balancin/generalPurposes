package br.com.balancin.amazingcep.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
 
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ZipcodeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Zipcode {

	String message() default "CEP invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
}
