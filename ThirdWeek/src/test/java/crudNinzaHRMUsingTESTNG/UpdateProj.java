package crudNinzaHRMUsingTESTNG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateProj {
	@Test
	public void update() {
		RestAssured.given()
		  .contentType(ContentType.JSON)
		  .body("{\r\n"
				    + "  \"createdBy\": \"Aarthi\",\r\n"
				    + "  \"projectName\": \"Blin\",\r\n"
				    + "  \"status\": \"Completed\",\r\n"
				    + "  \"teamSize\": 0\r\n"
				    + "}")
		.when().put("http://49.249.28.218:8091/project/NH_PROJ_3223")
		
		.then().statusCode(200).log().all();
	}

}
