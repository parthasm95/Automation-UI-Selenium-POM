package com.automazing.utils;

import java.util.Random;

public class RandomGenUtil {
	
	public static String getRandomEmail() {
		Random random = new Random();
		String email = "test" + random.nextInt(9999999) + "@automazing.com";
		return email;
	}

}
