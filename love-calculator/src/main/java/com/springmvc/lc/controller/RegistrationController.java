package com.springmvc.lc.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.lc.dto.CommunicationDTO;
import com.springmvc.lc.dto.Mobile;
import com.springmvc.lc.dto.UserRegisterDTO;
import com.springmvc.lc.propertyeditor.MyNamePropertyEditor;
import com.springmvc.lc.springvalidationapi.SpringValidator;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	@RequestMapping("/sign-in")
	public String showSignInPage(Model model, UserRegisterDTO userRegisterDto) {
		System.out.println(userRegisterDto.getName());
		System.out.println(userRegisterDto.getUserName());
		Mobile mobile = new Mobile();
		mobile.setCountryCode("91");
		mobile.setMobileNumber("1122334455");
		CommunicationDTO communicationDto = new CommunicationDTO();
		communicationDto.setMobile(mobile);
		userRegisterDto.setCommunicationDto(communicationDto);
		model.addAttribute("userRegister", userRegisterDto);
		System.out.println("Inside sign in page");
		return "sign-in";
	}

	@RequestMapping("/success-register")
	public String signInSuccess(@Valid @ModelAttribute("userRegister") UserRegisterDTO userRegisterDto,
			BindingResult result) {
		System.out.println("Inside Register success page");
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "sign-in";
		}
		return "register-success";
	}

	// gets called first before executing a every time a request is come to the RegistrationController
	@InitBinder 
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside InitBinder");
		StringTrimmerEditor editor = new StringTrimmerEditor(true);// trim white spaces set to true
		
		// binder.setDisallowedFields("hobby");// removes data bind of hobby field
		
		//trims the white space of field -name

		// binder.registerCustomEditor(String.class, "name", editor);
		
		// trims the white space of all Fields which has the data type 'String'
		binder.registerCustomEditor(String.class, editor);
		
		//custom formatter to convert all string to upper case;
		
		MyNamePropertyEditor strEditor=new MyNamePropertyEditor();
		binder.registerCustomEditor(String.class, "name",strEditor);
		
		//email validation using spring validation api
		binder.addValidators(new SpringValidator());
	}

}
