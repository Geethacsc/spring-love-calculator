package com.springmvc.lc.formatter;

//can perform same operation suing Formatter or PropertyEditor or Convertor
import java.util.Locale;

import org.springframework.format.Formatter;

import com.springmvc.lc.dto.Mobile;

public class MobileFormatter implements Formatter<Mobile> {

	@Override
	public Mobile parse(String completeMobileNumber, Locale locale) {
		System.out.println("Inside Mobile Formatter parse Method: " + completeMobileNumber.indexOf("-"));
		Mobile mob = new Mobile();
		int index = completeMobileNumber.indexOf("-");
		if (index != -1 && index != 0) {
			String[] mobArr = completeMobileNumber.split("-");// Note: spilt("+") is not working need to find out
			mob.setCountryCode(mobArr[0]);
			mob.setMobileNumber(mobArr[1]);
		} else {
			mob.setCountryCode("91");
			if (index == 0)
				mob.setMobileNumber(completeMobileNumber.substring(1));
			else
				mob.setMobileNumber(completeMobileNumber);
		}
		return mob;
	}

	@Override
	public String print(Mobile mob, Locale locale) {
		System.out.println("Inside print method");
		return mob.getCountryCode() + "-" + mob.getMobileNumber();
	}

}
