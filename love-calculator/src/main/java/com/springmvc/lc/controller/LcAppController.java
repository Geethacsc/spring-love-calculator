package com.springmvc.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.lc.dto.UserInfoDTO;
import com.springmvc.lc.dto.UserRegisterDTO;

import jakarta.validation.Valid;

import java.lang.*;

/**
 * @ModelAttribute or Model class - provide DATA BINDING --Suitable for Multiple
 *                 Fields
 * @RequestParam - Also provide DATA BINDING but for single Field
 */
@Controller
public class LcAppController {

	@RequestMapping("/")
	// public String homePage(Model model,UserInfoDTO userInfoDto) {
	public String homePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDto) {
		System.out.println(
				"inside home page--> using spring MVC form tag -helps in data binding(DTO) with @ModelAttribute \ninstead of @RequestParam and Model class incase multiple fields are sent as request");
		// model.addAttribute("userInfo",userInfoDto);--> replaced with @ModelAttribute
		return "home-page";
	}

	@RequestMapping("/process-homepage")

	/**
	 * Note: Controller with dto class instead of using @RequestParam for each field
	 * DTO class is used to bind data
	 * 
	 */
	// @Valid - Triggers the validation and bean validation result is store in
	// BindingResult
	public String resultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDto,
			BindingResult beanValidationResult) {

		System.out.println("userName: " + userInfoDto.getUserName());
		System.out.println("crushName: " + userInfoDto.getCrushName());

		if (beanValidationResult.hasErrors()) {
			System.out.println(beanValidationResult.getAllErrors());
			return "home-page";
		}
//		model.addAttribute("userName", userInfoDto.getUserName());
//		model.addAttribute("crushName", userInfoDto.getCrushName());
		return "result-page";
	}
	
	@RequestMapping("send-email")
	public String sendResult() {
		return "email-page";
	}
	
	/**Note: @RequestParam - fetch data from querystring/queryparameter
	 * 
	 * @param email
	 * @param model
	 * @return
	 * 
	 * @PathVariable - fetch data from the dynamic url
	 */
	
	
//	@RequestMapping(value="process-email/{email}")
//	public String sendEmail(@PathVariable("email") String email,Model model) {
//		System.out.println("email : "+email);
//		model.addAttribute("email",email);
//		return "email-success";
//	}
	
	@RequestMapping("process-email")
	public String sendEmail(@RequestParam("email") String email,Model model) {
		System.out.println("email : "+email);
		model.addAttribute("email",email);
		return "email-success";
	}
	
}
