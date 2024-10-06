package com.qa.opencart.utils;

public class StringUtil {
	public static String getRandomEmailId() {
		String emailId = "userauto" + System.currentTimeMillis() + "@opencart.com";
		System.out.println("user email Id : " + emailId);
		return emailId;
	}
}
