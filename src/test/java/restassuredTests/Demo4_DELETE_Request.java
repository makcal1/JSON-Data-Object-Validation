package restassuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETE_Request {


	@Test
	public void deleteEmployeeRecord() {
		RestAssured.baseURI = "https://reqres.in/api/users/4";


		Response response =

				given()
				.when()
				.delete()

				.then()

				.statusCode(204)
				.log().all()
				.extract().response();

		String jsonAsString =response.asString();





	}

}
