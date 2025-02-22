package com.springmvc.lc.service;

import org.springframework.stereotype.Component;

@Component
public class LcAppServiceImpl implements LcAppService {

	static final String FORMULA = "FLAME";

	@Override
	public String calculateLove(String userName, String crushName) {
		int nameLength = userName.concat(crushName).length();
		int formulaCount = FORMULA.length();
		System.out.println("chat: " + nameLength % formulaCount);
		char result = FORMULA.charAt(nameLength % formulaCount);
		System.out.println("char: " + result);
		return relation(result);
	}

	@Override
	public String relation(char result) {
		String relation = null;
		// TODO Auto-generated method stub
		switch (result) {
		case 'F': {
			relation = "FRIEND";
			break;
		}
		case 'L': {
			relation = "LOVE";
			break;
		}
		case 'A': {
			relation = "AFFECTION";
			break;
		}
		case 'M': {
			relation = "MARRIAGE";
			break;
		}
		case 'E': {
			relation = "ENEMY";
			break;
		}
		}
		return relation;

	}

}
