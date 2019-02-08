package com.makingsense.test;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import com.makingsense.data.Constants;
import com.makingsense.utils.Utils;


public class HelloWorldTest{
	
	Utils utils = new Utils();
	
	@BeforeClass
    public static void setup() {
		
		
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);        	
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }    
		
        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/DPS-1/rs/api/cad";
            
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://192.168.170.58";
        }
        RestAssured.baseURI = baseHost;
        
    }
	
	
	
    
}

