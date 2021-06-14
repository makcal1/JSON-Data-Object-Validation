package restassuredTests;

import java.util.HashMap;
import  static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo3_PUT_Request {

	public static HashMap map = new HashMap();

	String empName =  RestUtils.empName();
	String empSal =  RestUtils.empSal();
	String empAge =  RestUtils.empAge();
	int emp_id = 2;

	@BeforeClass
	public void putData() {


		map.put("name", empName);
		map.put("salary", empSal);
		map.put("age", empAge);

		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath= "/users/"+ emp_id;
	}
	@Test
	public void testPUT() {

		given()
		.contentType("application/json; charset=utf-8")
		.body(map)
		.when()
		.put().then().and().
		statusCode(200).log().all();
	}

}
