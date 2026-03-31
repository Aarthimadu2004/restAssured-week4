package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteUser {
	@Test
	public void delete() {
		RestAssured.given()
		   .formParam("email", "aarthimadhumitha@gmail.com")
		   .formParam("password", "Madhu2004")
		
		.when().delete("https://automationexercise.com/api/deleteAccount")
		
		.then().log().all();
	}

}
