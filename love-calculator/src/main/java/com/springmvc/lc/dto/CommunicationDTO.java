package com.springmvc.lc.dto;

public class CommunicationDTO {

	public CommunicationDTO() {
		System.out.println("Inside CommunicationDTO");
	}
	private String email;
	private Mobile mobile;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

}
