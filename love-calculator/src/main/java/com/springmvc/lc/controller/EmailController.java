package com.springmvc.lc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springmvc.lc.dto.UserInfoDTO;
import com.springmvc.lc.service.EmailService;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping("send-email")
	public String sendResult() {
		return "email-page";
	}

	/**
	 * Note: @RequestParam - fetch data from querystring/queryparameter
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
	public String sendEmail(@RequestParam("email") String email, Model model,
			@SessionAttribute("userInfo") UserInfoDTO userInfoDTO,@SessionAttribute("relation") String relation) {
		System.out.println("email : " + email);
		model.addAttribute("userName", userInfoDTO.getUserName());
		System.out.println("inside send Email,crushName: "+userInfoDTO.getCrushName());
		model.addAttribute("email", email);
		emailService.sendMail(userInfoDTO, email, relation);
		return "email-success";
	}

}
