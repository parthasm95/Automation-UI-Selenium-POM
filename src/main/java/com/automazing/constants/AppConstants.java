package com.automazing.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_LONG_TIME_OUT = 20;
	
	//TestData File
	public static final String TEST_DATA_EXCEL_FILEPATH = "./src/test/resources/testdata/TestData.xlsx";
	public static final String CREATE_ACC_SHEETNAME = "createAccount";
	
	
	//Login Page
	public static final String LOGIN_PAGE_TITLE_VALUE = "Login - My Shop";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "back=my-account";

	//Accounts Page
	public static final String ACCOUNTS_PAGE_TITLE_VALUE = "My account - My Shop";
	public static final String ACCOUNTS_PAGE_URL_FRACTION_VALUE = "controller=my-account";
	public static final int ACCOUNTS_PAGE_ITEMS_COUNT = 6;
	public static final List<String> EXPECTED_ACCOUNTS_PAGE_ITEMS_LIST = Arrays.asList("ADD MY FIRST ADDRESS", 
																						"ORDER HISTORY AND DETAILS", 
																						"MY CREDIT SLIPS",
																						"MY ADDRESSES", 
																						"MY PERSONAL INFORMATION", 
																						"Home");
	public static final String CREATE_ACC_SUCESS_MSG = "Your account has been created.";
	
	//Home Page
	public static final String HOME_PAGE_TITLE_VALUE = "My Shop";
	public static final List<String> EXPECTED_HOME_PAGE_NAV_ITEMS_LIST = Arrays.asList( "Partha Mohapatra",
																						"Sign out",
																						"Contact us");
	
	public static final List<String> EXPECTED_HOME_PAGE_CTGR_ITEMS_LIST = Arrays.asList("WOMEN", 
																						"DRESSES", 
																						"T-SHIRTS",
																						"BLOG");
	//Search Page
	public static final String SEARCH_PAGE_TITLE_VALUE = "Search - My Shop";


}
