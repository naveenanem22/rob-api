package com.rob.custom.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class GenderValidator implements ConstraintValidator<GenderConstraint, String> {

	@Autowired
	private Environment env;

	@Override
	public void initialize(GenderConstraint gender) {
	}

	@Override
	public boolean isValid(String genderField, ConstraintValidatorContext cxt) {

		if (genderField.equalsIgnoreCase(env.getProperty("gender.values.male"))
				|| genderField.equalsIgnoreCase(env.getProperty("gender.values.female")))
			return true;
		else
			return false;
	}

}
