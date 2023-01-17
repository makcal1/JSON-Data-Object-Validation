package restassuredTests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers. *;
import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import  static io.restassured.matcher.RestAssuredMatchers.*;


public class JsonResponseSingleBodyValidation {

	@Test
	public void testJsonResponse() {

	     
		Response res = 
				given()
				.when()
				.get("https://reqres.in/api/users?page=2");
		
		assertEquals(res.getStatusCode(),200);
		
		assertEquals(res.header("Transfer-Encoding"),"chunked");
		
	

		
		JSONObject jo = new JSONObject(res.asString());
		System.out.println(jo);
		
		boolean status = false;
		
		for (int i = 0; i < jo.getJSONArray("data").length(); i++) 
		{
			
			String emeailAdress = jo.getJSONArray("data").getJSONObject(i).getString("email").toString();
			
			
			if(emeailAdress.equals("byron.fields@reqres.in"))
			{
				status = true;
				break;
			}
	
			
		}
			assertEquals(status, true);
		

	}


}
