
package com.springmvc.lc.dto;
import com.springmvc.lc.validator.Age;
import com.springmvc.lc.validator.Phone;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//@NotEmpty , @NotBlank ,etc -bean validation API- hibernate validator
//Spring validation Api- Validator class

public class UserRegisterDTO {

	public UserRegisterDTO() {
		System.out.println("**Inside UserRegisterDTO**");
	}

	@NotEmpty(message = "*name cannot be Empty")
	@Size(min = 3, max = 15, message = "*userName should be between 3-15") // accepts white space
	private String name = "name";

	@NotEmpty(message = "*userName should not be Empty")
	@Size(min = 3, max = 15, message = "*userName should be between 3-15") // accepts white space
	private String userName = "User ID";
	private char[] password;
	private String country;
	private String gender;
	@Age(min = 20, max = 60)
	private int age;
	private String[] hobby;
	@Phone
	private CommunicationDTO communicationDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public CommunicationDTO getCommunicationDto() {
		return communicationDto;
	}

	public void setCommunicationDto(CommunicationDTO communicationDto) {
		this.communicationDto = communicationDto;
	}

}
