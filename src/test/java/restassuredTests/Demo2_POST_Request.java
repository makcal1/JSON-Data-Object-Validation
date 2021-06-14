package restassuredTests;

import java.util.HashMap;
import java.util.Map;
import  static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_POST_Request {


	public static HashMap map = new HashMap();

	@BeforeClass
	public void postdata() 
	{

		map.put("FirstName",RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("Username", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", 	RestUtils.getEmail());

		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users";

	}

	@Test
	public void testPost() {


		given().contentType("application/json; charset=utf-8")
		.body(map)

		.when()
		.post()
		
		.then()
		.statusCode(201);


	}
}
