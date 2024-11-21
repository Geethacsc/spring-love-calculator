package com.springmvc.lc.validator;

import com.springmvc.lc.dto.CommunicationDTO;
import com.springmvc.lc.dto.Mobile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileConstraint implements ConstraintValidator<Phone, CommunicationDTO> {

	private int number;
	private int countryCode;
	public void initialize(Phone phone) {
		System.out.println("Inside initialize mobile");
		this.number=phone.number();
		this.countryCode=phone.countryCode();
	}
	@Override
	public boolean isValid(CommunicationDTO dto, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		Mobile mobile = dto.getMobile();
		try {
			Integer.parseInt(mobile.getCountryCode());
			System.out.println("countryCode: "+mobile.getCountryCode());
			Double.parseDouble(mobile.getMobileNumber());
			System.out.println(mobile.getMobileNumber());
		} catch (Exception e) {
			System.out.println("inside catch: " + e);
			mobile.setCountryCode("");
			mobile.setMobileNumber("");
			return false;
		}

		return mobile.getMobileNumber().length() == number && mobile.getCountryCode().length() <= countryCode;
	}

}
