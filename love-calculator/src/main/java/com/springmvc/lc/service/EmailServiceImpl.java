package com.springmvc.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springmvc.lc.dto.UserInfoDTO;

@Component
public class EmailServiceImpl implements EmailService {

//	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendMail(UserInfoDTO userInfoDTO, String mailId, String result) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mailId);
		mailMessage.setSubject("Love Calculator");
		mailMessage.setText("Hi " + userInfoDTO.getUserName() + ",Your Relation with "+userInfoDTO.getCrushName()+" is: " + result);

		javaMailSender.send(mailMessage);

	}

}
