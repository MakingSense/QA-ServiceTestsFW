package com.makingsense.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.makingsense.servicetesting.BaseTest;
import com.makingsense.utils.Utils;
 

public class APISuiteTest extends BaseTest {

	
	@Test
	public void verifyPostsAPIStatusCodeTest()
	{								
		given().when().get("/posts").then().statusCode(200);	
	}

	
	@Test
	public void verifyAllPostsAPIBodyTest()
	{	
		int expectedListSize = 100;
		
		Response response = given().when().get("/posts");
		assertEquals(100, response.jsonPath().getList("$").size());
		
		logger.info("\n Expected list size : " + expectedListSize);
		
	}

	
	@Test
	public void verifySpecificPostIsPresentTest()
	{	
		String expectedPostTitle = "qui est esse";
		
		Response response = given().when().get("/posts");
		assertEquals(expectedPostTitle, response.jsonPath().getList("title").get(1));
		
		logger.info("\n Expected Post title : " + expectedPostTitle + "\nCurrent title: " + response.jsonPath().getList("title").get(1));
		
	}
	
	
	@Test
	public void getAllsPostsTest()
	{		
		// TEST DATA
		String api_path = "posts";
		String api_sub_path = Utils. buildURL(api_path);
		
		// EXPECTED VALUES
		int expectedPostsQuantity = 100;
		int expectedStatusCode = 200;
				
				
		logger.info("\n Request details: ");
		
		Response resp = 
							given()
							.when()
							.log()
							.method()  	
							.and()
							.log()
							.uri()		
							.get(api_sub_path);	
		
		
		assertEquals(resp.getStatusCode(), expectedStatusCode);
		logger.info("\n Response status code: " + resp.statusCode());
		
	
		assertEquals(resp.jsonPath().getList("$").size(), expectedPostsQuantity);		
		logger.info("\n Response size is: " + resp.jsonPath().getList("$").size());
	
	}
	
	@Test
	public void getOnePostTest()
	{		
		// EXPECTED VALUES
		String expectedTitle = "qui est esse";
		String expectedId = "2";
		
		// TEST DATA
		String post_id = "2";	
		String api_path = "posts";
		String api_sub_path = Utils. buildURL(api_path) + Utils.buildURL(post_id);		
		
		logger.info("\n Request details: ");
		
		Response resp = 
				given()
				.when()
				.log()
				.method()  	
				.and()
				.log()
				.uri()		
				.get(api_sub_path);
		
		
		// STEP 1:  Verify response status code
		assertEquals(resp.getStatusCode(), 200);
		
		// EXPECTED RESULT: 200
		logger.info("\n Response status code: " + resp.statusCode());
		
		
		// STEP 2:  Verify post title  
		assertEquals(resp.jsonPath().getString("title"), expectedTitle);
		
		// EXPECTED RESULT: "qui est esse"
		logger.info("\n Response size is: " + resp.jsonPath().getString("title"));
		
		
		// STEP 3:  Verify post id		
		assertEquals(resp.jsonPath().getString("id"), expectedId);
		
		// EXPECTED RESULT: 2
		logger.info("\n Response size is: " + resp.jsonPath().getString("id"));
		
		
		// Prints response
		logger.info(resp.getBody().asString());		
	}
	
	@Test
	public void verifyEmailForACommentTest()
	{		
		// EXPECTED VALUES
		String expectedCommentEmail = "Eliseo@gardner.biz";
		int expectedCommentsForPost = 5;
				
		// TEST DATA
		String post_id = "comments";
		String parameterURL = "?postId=1";
		String api_sub_path = Utils. buildURL(post_id) + parameterURL;	
				
		logger.info("\n Request details: ");
		
		Response resp = 
							given()
							.when()
							.log()
							.method()  	
							.and()
							.log()
							.uri()		
							.get(api_sub_path);
		
		// STEP 1:  Verify response status code
		assertEquals(resp.getStatusCode(), 200);
		
		// EXPECTED RESULT: 200
		logger.info("\n Response status code: " + resp.statusCode());		
		
		
		// STEP 2:  Verify email of comments		
		assertEquals(resp.jsonPath().getList("$").size(), expectedCommentsForPost);
		
		// EXPECTED RESULT: 5
		logger.info("\n Response size is: " + resp.jsonPath().getList("$").size());
		
		
		
		// STEP 3:  Verify if email "Eliseo@gardner.biz" is included		
		assertTrue(resp.jsonPath().getString("email").contains(expectedCommentEmail));
		
		// EXPECTED RESULT: true
		logger.info("\n Response size is: " + resp.jsonPath().getString("email"));

	}
	
}