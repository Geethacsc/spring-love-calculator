package com.springmvc.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.lc.dto.UserInfoDTO;

@Controller
public class ScopeController {
	
	@RequestMapping("/approach2")
	public String homePage2() {
		System.out.println("Inside Approach2 Page, using Data Binding--->DTO class to get each fields Data");
		return "sample-page1";
	}

	@RequestMapping("/process-sample1") // get request from user using Databinding DTO class
	public String resultPage(UserInfoDTO userInfo, Model model) {
		System.out.println("Inside approach 2");
		System.out.println("userName: " + userInfo.getUserName());
		System.out.println("crushName: " + userInfo.getCrushName());
		model.addAttribute("userName", userInfo.getUserName());
		model.addAttribute("crushName", userInfo.getCrushName());

		return "sample-result1";
	}
	
	@RequestMapping("session-scope") // get request from user using Databinding DTO class
	public String scopePage(UserInfoDTO userInfo, Model model) {
		System.out.println("Inside approach 2");
		System.out.println("userName: " + userInfo.getUserName());
		System.out.println("crushName: " + userInfo.getCrushName());
		model.addAttribute("userName", userInfo.getUserName());
		model.addAttribute("crushName", userInfo.getCrushName());

		return "scope";
	}
}
