package serializationDesererilization;

import org.testng.Assert;
import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers. *;

public class VideoGameAPITestwithSerializationXML {


	@Test(priority = 1)
	public void testVideoGameSerializationXML() {

		VideoGame myVideoGame = new VideoGame();
		myVideoGame.setId(17);
		myVideoGame.setName("xyz123");
		myVideoGame.setReleaseDate("06/15/2021");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driving");
		myVideoGame.setRating("Five");

		given()
		.contentType("application/xml")
		.body(myVideoGame)

		.when()

		.post("http://localhost:8080/app/videogames")
		.then()
		.log().all()
		.body(equalTo("{\"status\": \"Record Added Successfully\"}"));



	}

	@Test(priority = 2)
	public void testVideoGameDeSerializationXML() {

		VideoGame myVideoGame = get("http://localhost:8080/app/videogames/9")
				.as(VideoGame.class);
		System.out.println(myVideoGame.toString());







	}
}
