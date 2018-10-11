package com.rob.custom.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ScoreTypeValidator implements ConstraintValidator<ScoreTypeConstraint, String> {

	@Autowired
	private Environment env;

	@Override
	public void initialize(ScoreTypeConstraint scroreType) {
	}

	@Override
	public boolean isValid(String scoreTypeField, ConstraintValidatorContext cxt) {

		if (scoreTypeField.equalsIgnoreCase(env.getProperty("score.values.gpa"))
				|| scoreTypeField.equalsIgnoreCase(env.getProperty("score.values.percentage")))
			return true;
		else
			return false;
	}

}
