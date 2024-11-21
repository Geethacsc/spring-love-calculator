package com.springmvc.lc.springvalidationapi;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.lc.dto.UserRegisterDTO;

//spring framework validation api - Validator
public class SpringValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		System.out.println("inside supports method");
		return UserRegisterDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("inside spring validation api"+target.getClass().getName());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDto.email", "email.empty", "Email cannot be empty");
	}

}
