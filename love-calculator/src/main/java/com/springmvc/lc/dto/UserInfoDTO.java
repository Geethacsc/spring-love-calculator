package com.springmvc.lc.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//Data Binding
public class UserInfoDTO {

	@NotBlank(message="*Your Name cannot not be Empty")
	//@Min(value=3,message="*Your Name should not less than 3 letters")
	@Size(min=3,max=15,message="*Your Name should be between 3 to 15")
	private String userName;// should be same as the param name
	@NotBlank(message="*Crush Name cannot not be Empty")
	@Size(min=3,max=15,message="*Crush Name should be between 3 to 15")
	private String crushName;
	
	@AssertTrue(message="*Agree to use our app")//should always be true
	private boolean termsAndConditions;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(boolean termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

}
