package crudNinzaHRMUsingTESTNG;
//NH_PROJ_3223

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetProj {
	@Test
	public void getPro() {
	RestAssured.given()
		
		.when().get("http://49.249.28.218:8091/project/NH_PROJ_3223")
		
		.then().statusCode(200).log().all();

	
	}
}
