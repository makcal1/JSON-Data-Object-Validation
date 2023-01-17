package restassuredTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers. *;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import  static io.restassured.matcher.RestAssuredMatchers.*;


public class JsonPathValidation {

	@Test
	public void testJsonResponse() {

	     
		Response rs = given().get("https://reqres.in/api/users?page=2");
		
		assertEquals(rs.getStatusCode(),200);
		
		assertEquals(rs.header("Transfer-Encoding"),"chunked");
		
		String emailAdressString = rs.jsonPath().get("data[2].email".toString());
		
		assertEquals(emailAdressString, "tobias.funke@reqres.in");

		
		
		

		

	}


}
