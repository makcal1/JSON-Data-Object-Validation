package restassuredTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers. *;

import java.util.concurrent.TimeUnit;

import  static io.restassured.matcher.RestAssuredMatchers.*;


public class SingleValidationApproach {

	@Test
	public void testJsonResponse() {

	     given()

		.get("https://reqres.in/api/users?page=2")
		
		.then()
		
		.contentType("application/json")
		.statusCode(200)
		
		.and()

		.body("data[2].email", equalTo("tobias.funke@reqres.in"))
		
		.log().headers()
	
		.log().body();
		
		
		

		

	}


}
