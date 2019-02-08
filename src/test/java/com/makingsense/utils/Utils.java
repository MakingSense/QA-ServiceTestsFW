package com.makingsense.utils;
import com.makingsense.data.*;;

public class Utils {
	

	public static String getBaseHost()
	{
		return Constants.BASE_HOST;
		
	}
	
	public static void set_authorization_token(String token)
	{
		Constants.set_bearer_token(token);
		
	}
	
	public static String get_authorization_token()
	{
		return Constants.get_bearer_token();
		
	}
	
	public static String buildURL(String url)
	{
		String back_slash = "/";
		return back_slash + url;
	}

}
