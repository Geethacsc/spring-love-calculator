package com.springmvc.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.lc.dto.UserInfoDTO;

@Controller
public class SampleController {

	@RequestMapping("/approach1")
	public String homePage1() {
		System.out.println("Inside Approach1 Page---> using @RequestParam to get each fields Data");
		return "sample-page";
	}

	@RequestMapping("/process-sample")

	// Note: @RequestParam String userName not working throwing error
	public String resultPage(@RequestParam("userName") String userName1, @RequestParam("crushName") String crushName1,
			Model model) {
		System.out.println("inside approach 1");
		System.out.println("userName: " + userName1);
		System.out.println("crushName: " + crushName1);
		model.addAttribute("userName", userName1);
		model.addAttribute("crushName", crushName1);

		return "sample-result";
	}

}
