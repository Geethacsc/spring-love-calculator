package com.springmvc.lc.service;

import org.springframework.stereotype.Service;

import com.springmvc.lc.dto.UserInfoDTO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface EmailService {
	
	void sendMail(UserInfoDTO userInfoDTO,String mailId,String result);
}
