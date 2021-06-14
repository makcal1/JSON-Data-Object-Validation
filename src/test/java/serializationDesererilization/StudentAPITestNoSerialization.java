package serializationDesererilization;

import java.util.ArrayList;
import java.util.HashMap;

import  static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers. *;

public class StudentAPITestNoSerialization {

	public HashMap map = new HashMap();
	//Post requests creates a new student record
	@Test(priority = 1)
	public void createNewStudent() {

		map.put("id",101);
		map.put("firstName","Pavan");
		map.put("lastName","Kumar");
		map.put("email","abcxyz@gmail.com");
		map.put("programme","Manger");


		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");


		map.put("courses", coursesList);

		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()

		.post("http://localhost:8085/student")
		.then()
		.statusCode(201)
		.assertThat()
		.body("msg", equalTo("Student added"))
		.log().all();

	}
	@Test(priority = 2)
	//Get Request to retrieve student details
	void getStudentRecord() {

		 given()
		.when()
		.get("http://localhost:8085/student/101")
		.then()
		.statusCode(200)
		.assertThat()
		.body("firstName", equalTo("Pavan"))
		.log().all();


	}


}
