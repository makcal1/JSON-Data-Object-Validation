package restassuredTests;

import  static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers. *;

public class Demo6_BasicValidations_XML {
	@Test(priority = 1)
	void testSingleContent() {

		given()

		.when()
		.get("https://reqres.in/api/users/5")

		.then()
		.body("data.first_name",equalTo("Charles")).log().all();

	}

	@Test(priority = 2)
	void testMultipleContent() {

		given()

		.when()

		.get("https://reqres.in/api/users/5")

		.then()

		.body("data.first_name",equalTo("Charles"))

		.body("data.email",equalTo("charles.morris@reqres.in"))

		.body("data.last_name",equalTo("Morris"))

		.body("data.avatar",equalTo("https://reqres.in/img/faces/5-image.jpg"))

		.log().all();

	}
	@Test(priority = 4)
	void testUsingXPath1() {
		given()

		.when()

		.get("https://reqres.in/api/users/5")

		.then()

		.body("data.first_name",containsString("Charles"))

		.log().all();

	}
@Test(priority = 5)
void testUsingXPath() {
	
	
	given()

	.when()

	.get("https://reqres.in/api/users?page=2")

	.then()

	.body("data.first_name",hasItems("Lindsay","Tobias","Byron"))

	.log().all();
	
}





}
