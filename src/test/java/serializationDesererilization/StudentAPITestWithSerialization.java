package serializationDesererilization;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers. *;
public class StudentAPITestWithSerialization {


	@Test(priority = 1)
	public void createNewStudentSerialization() {
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");

		Student student = new Student();
		student.setSID(101);
		student.setFirstName("John");
		student.setLastName("Deo");
		student.setEmail("abc@gmail.com");
		student.setProgramme("Computer science");
		student.setCourses(coursesList);

		given()
		.contentType(ContentType.JSON)
		.body(student)

		.when()
		.post("http://localhost:8085/student")

		.then()

		.statusCode(201)
		.assertThat()
		.body("msg", equalTo("Student added"));

	}
	@Test(priority = 2)
	void getStudentRecordDeSerilization() {

		Student stu = get("http://localhost:8085/student").as(Student.class);

		System.out.println(stu.getStudentRecord());

		Assert.assertEquals(stu.getSID(), 101);



	
	}



}
