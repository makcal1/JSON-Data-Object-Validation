package restassuredTests;
import  static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers. *;
public class Demo5_BasicValidations_JSON {


	@Test(priority = 1)
	public void testStatusCode() {

		given()

		.when()
		.get("https://reqres.in/api/unknown/2")

		.then()

		.statusCode(200).log().all();



	}

	// 2-) Log Response
	@Test(priority = 2)
	public void testLogging() {


		given()

		.when()
		.get("https://reqres.in/api/unknown/3")
		.then().statusCode(200)
		.log().all();


	}


	@Test(priority = 3)
	public void testSingleContent() {


		given()

		.when()
		.get("https://reqres.in/api/users/2")
		.then().statusCode(200)
		.body("data.email", equalTo("janet.weaver@reqres.in"))
		.log().all();


	}
	@Test(priority = 4)
	public void testMultipleContent() {


		given()

		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().statusCode(200)
		.body("data.first_name", hasItems("Michael","Lindsay","Tobias","Byron"))
		.log().all();


	}





}
