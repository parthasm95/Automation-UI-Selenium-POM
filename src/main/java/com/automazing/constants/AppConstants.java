package com.automazing.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_LONG_TIME_OUT = 20;

	public static final String LOGIN_PAGE_TITLE_VALUE = "Login - My Shop";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "back=my-account";

	public static final String ACCOUNTS_PAGE_TITLE_VALUE = "My account - My Shop";
	public static final String ACCOUNTS_PAGE_URL_FRACTION_VALUE = "controller=my-account";
	public static final int ACCOUNTS_PAGE_ITEMS_COUNT = 6;
	
	public static final List<String> EXPECTED_ACCOUNTS_PAGE_ITEMS_LIST = Arrays.asList("ADD MY FIRST ADDRESS", "ORDER HISTORY AND DETAILS", "MY CREDIT SLIPS",
																						"MY ADDRESSES", "MY PERSONAL INFORMATION", "Home");

}
