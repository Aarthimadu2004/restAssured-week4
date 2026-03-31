package crudNinzaHRMUsingTESTNG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateProj {
	@Test
	public void addProj() {
		RestAssured.given()
		 .contentType(ContentType.JSON)
		   .body("{\r\n"
				    + "  \"createdBy\": \"Aarthi\",\r\n"
				    + "  \"projectName\": \"Blin1\",\r\n"
				    + "  \"status\": \"Created\",\r\n"
				    + "  \"teamSize\": 0\r\n"
				    + "}")
		
		.when().post("http://49.249.28.218:8091/addProject")
		
		.then().log().all();
	}
	

}
