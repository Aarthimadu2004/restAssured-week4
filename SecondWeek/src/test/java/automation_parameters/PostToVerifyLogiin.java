package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostToVerifyLogiin {

	@Test
	public void verify() {
		RestAssured.given()
		 .formParam("email", "aarthimadhumitha@gmail.com")
		  .formParam("password", "Mad2004")
		
		.when().post("https://automationexercise.com/api/verifyLogin")
		
		.then().log().all();
	}
}
