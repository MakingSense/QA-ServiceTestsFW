package com.makingsense.servicetesting;

import org.testng.annotations.BeforeClass;
import java.util.logging.*;

import io.restassured.RestAssured;
import com.makingsense.utils.Utils;

public class BaseTest {
	
	public final static Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	@BeforeClass
    public static void setup() {
		   
		logger.setLevel(Level.INFO);
		
		logger.info("\n Setting [basepath]");
        
        logger.info("\n Setting the basehost");
        
        String baseHost = System.getProperty("server.host");
        
        if(baseHost==null){
            baseHost = Utils.getBaseHost();
            
        }
        
        RestAssured.baseURI = baseHost;
        logger.info("\n [basehost] set to: " + "\'" +  baseHost + "\'");
    }

}
