package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetUserByEmail {
	@Test
	public void getUser() {
		RestAssured.given()
		   .formParam("email", "aarthimadhumitha@gmail.com")
		
		.when().get("https://automationexercise.com/api/getUserDetailByEmail")
		
		.then().log().all();
	}

}
