package com.springmvc.lc.dto;

public class Mobile {

	private String countryCode;
	private String mobileNumber;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	//by default wheenever we try print the value of object every object calls the toString() method sysout(mobile)=mobile.toString();

	@Override
	public String toString() {
		return countryCode+"-"+mobileNumber;
	}
}
