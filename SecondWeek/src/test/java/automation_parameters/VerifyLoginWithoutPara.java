package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class VerifyLoginWithoutPara {

	@Test
	public void verify() {
		RestAssured.given()
		
		
		.when().post("https://automationexercise.com/api/verifyLogin")
		
		.then().log().all();
	}
}
