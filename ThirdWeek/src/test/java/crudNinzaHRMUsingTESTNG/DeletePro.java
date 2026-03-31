package crudNinzaHRMUsingTESTNG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeletePro {
	@Test
	public void delete() {
RestAssured.given()
		
		.when().delete("http://49.249.28.218:8091/project/NH_PROJ_3223")
		
		.then().statusCode(204).log().all();
	}

}
