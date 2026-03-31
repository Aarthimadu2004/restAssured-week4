package crudNinzaHRMUsingTESTNG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllPro {
	@Test
	public void getAll() {
RestAssured.given()
		
		.when().get("http://49.249.28.218:8091/projects")
		
		.then().statusCode(200).log().all();
	}

	

}
