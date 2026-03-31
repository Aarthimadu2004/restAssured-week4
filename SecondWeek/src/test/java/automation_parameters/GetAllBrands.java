package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllBrands {

	@Test
	public void getAll() {
		RestAssured.given()
		
		.when().get("https://automationexercise.com/api/brandsList")
		
		.then().log().all();
		
	}
}
