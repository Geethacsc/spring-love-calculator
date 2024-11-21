package com.springmvc.lc.converter;

import org.springframework.core.convert.converter.Converter;

import com.springmvc.lc.dto.Mobile;
//MobileFormatter class also performs the same task
public class MobileConverter implements Converter<String, Mobile> {

	@Override
	public Mobile convert(String str) {
		System.out.println("Inside Mobile Converter");
		Mobile mobile = new Mobile();
		if (str.indexOf("-") != -1 && str.indexOf("-") != 0) {
			String[] mobArr = str.split("-");
			mobile.setCountryCode(mobArr[0]);
			mobile.setMobileNumber(mobArr[1]);
		} else {
			mobile.setCountryCode("91");
			if (str.indexOf("-") == 0) {
				mobile.setMobileNumber(str.substring(1));
			} else {
				mobile.setMobileNumber(str);
			}
		}
		return mobile;
	}

}
