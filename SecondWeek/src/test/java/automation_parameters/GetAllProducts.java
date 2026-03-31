package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllProducts {
	@Test
	public void getAll() {
		RestAssured.given()
		
		.when().get("https://automationexercise.com/api/productsList")
		
		.then().log().all();
		
	}

}
