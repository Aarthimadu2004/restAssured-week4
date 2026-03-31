package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteToVerifyLogin {
	@Test
	public void verify() {
		RestAssured.given()
		
		
		.when().delete("https://automationexercise.com/api/verifyLogin")
		
		.then().log().all();
	}

}
