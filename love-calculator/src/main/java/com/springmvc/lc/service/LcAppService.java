package com.springmvc.lc.service;

import org.springframework.stereotype.Service;

@Service
public interface LcAppService {

	
	String calculateLove(String userName,String crushName);
	String relation(char result);
}
