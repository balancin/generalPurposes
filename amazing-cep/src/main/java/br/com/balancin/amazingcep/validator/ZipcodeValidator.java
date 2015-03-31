package br.com.balancin.amazingcep.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipcodeValidator implements ConstraintValidator<Zipcode, String> {

	@Override
	public void initialize(Zipcode constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null)
			return false;
		
		if(value.matches("\\d{5}-\\d{3}")) return true;
		else return false;
		
	}

}
