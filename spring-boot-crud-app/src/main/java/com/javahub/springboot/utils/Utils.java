package com.javahub.springboot.utils;

//import java.security.SecureRandom;
//import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

//	private final Random random = new SecureRandom();
//	private final String ALPHABET = "0123456789abcdefghijklmnopqrstuvxyzABCDEFGHIKJLMNOPQRSTUVXYZ";

	public String generateRandomNumber() {
		int randomNumber = (int)(Math.random()*99999)+10000;
		String number = String.valueOf(randomNumber);
		return number;
	}

//	private String generateRandomString(int length) {
//		StringBuilder sb = new StringBuilder(length);
//
//		for (int i = 0; i < length; i++) {
//			sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
//		}
//		return new String(sb);
//	}
	
}
