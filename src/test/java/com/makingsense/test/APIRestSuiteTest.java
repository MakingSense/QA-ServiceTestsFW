package com.makingsense.test;

import com.google.gson.JsonObject;
import com.makingsense.servicetesting.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIRestSuiteTest extends BaseTest {

    @Test
    public void verifyGetPosts_Returns_200_with_userId_And_postsId() {
        //http://jsonplaceholder.typicode.com/posts?userId=1&id=2
        given().params("userId", "1", "id", "2").
                when().
                get("/posts").
                then().statusCode(200);
    }

    @Test
    public void verifyGetUsers_Returns_200_with_userId()
    {
        //http://jsonplaceholder.typicode.com/users/1
        given().params("id", "1").
                when().
                get("/users/").
                then().statusCode(200).body("[0].name", equalTo("Leanne Graham"));
    }

    @Test
    public void verifyCreatePost_Returns_201() {

        // Create new JSON Object
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("title", "foo");
        requestBody.addProperty("body", "bar");
        requestBody.addProperty("userId", "1");
        requestBody.addProperty("id", "550");

        //http://jsonplaceholder.typicode.com/posts?userId=1&id=2
        given()
                .header("Content-Type", "application/json")
                .when()
                .body(requestBody.toString())
                .post("/posts")
                .then().statusCode(201);
    }

}
