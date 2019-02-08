package com.makingsense.data;

public  class Constants {
	
	// BaseHost 
	public static String BASE_HOST = "https://jsonplaceholder.typicode.com";

	// APIs
	public static String LOGIN_API = "/login";
	
	// token
	public static String BEARER_TOKEN = "";
	
	
	// set bearer token
	
	public static void set_bearer_token(String token)
	{
		BEARER_TOKEN = token;
	}
	
	// get bearer token
	
	public static String get_bearer_token()
	{
		return BEARER_TOKEN;
	}
	
	public static String getBaseHost()
	{
		return BASE_HOST;
	}
}
