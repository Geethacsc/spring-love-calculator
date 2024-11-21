package com.springmvc.lc.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeConstraint implements ConstraintValidator<Age, Integer>{

	private int min;
	private int max;
	
	public void initialize(Age age) {
		System.out.println("inside initialize");
		min=age.min();
		max=age.max();
	}
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(value==0 || value==null)
			return false;

		return value>=min && value<=max;
	}
}
