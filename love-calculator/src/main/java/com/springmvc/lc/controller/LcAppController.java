package com.springmvc.lc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.lc.dto.UserInfoDTO;
import com.springmvc.lc.service.LcAppService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/**
 * @ModelAttribute or Model class - provide DATA BINDING --Suitable for Multiple
 *                 Fields
 * @RequestParam - Also provide DATA BINDING but for single Field
 */

/*
 * @SessionAttributes only stores Model Attribute Values
 * @SessionAttributes will not work with @ModelAttribute
 * It is not recommended to use @SessionAtttribute for storing Permanent data in Http Session
 * @SessionAttribute is used to get data from @SessionAttributes value in another Controller
 */
@Controller
@SessionAttributes({"userInfo","relation"})
public class LcAppController {

	@Autowired
	private LcAppService lcpAppService;
	
	@RequestMapping("/")
	public String homePage(Model model,UserInfoDTO userInfoDto,HttpServletRequest request) {
	//public String homePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDto,HttpServletRequest request) {
		System.out.println(
				"inside home page--> using spring MVC form tag -helps in data binding(DTO) with @ModelAttribute \ninstead of @RequestParam and Model class incase multiple fields are sent as request");
		model.addAttribute("userInfo",userInfoDto);//--> replaced with @ModelAttribute but not work with @SessionAttributes
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			System.out.println(cookies.toString());
			for(Cookie cookie:cookies)
				if(cookie.getName().equals("cookie_userName"))
					userInfoDto.setUserName(cookie.getValue());
		}
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
			BindingResult beanValidationResult, HttpServletRequest request,HttpServletResponse response,Model model) {

		System.out.println("userName: " + userInfoDto.getUserName());
		System.out.println("crushName: " + userInfoDto.getCrushName());
		if (beanValidationResult.hasErrors()) {
			System.out.println(beanValidationResult.getAllErrors());
			return "home-page";
		}
//		model.addAttribute("userName", userInfoDto.getUserName());
//		model.addAttribute("crushName", userInfoDto.getCrushName());
		Cookie cookie = new Cookie("cookie_userName", userInfoDto.getUserName());
		response.addCookie(cookie);
		
		HttpSession session = request.getSession();
		session.setAttribute("mysession_name", userInfoDto.getUserName());
		session.setAttribute("mysession_crush", userInfoDto.getCrushName());
		session.setMaxInactiveInterval(120);// 120 minutes
		
		String relation=lcpAppService.calculateLove(userInfoDto.getUserName(), userInfoDto.getCrushName());
		model.addAttribute("relation", relation);
		return "result-page";
	}

}
