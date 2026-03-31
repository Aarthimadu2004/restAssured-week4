package methodChaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class NinzaAPIChain {
	String projectId;
	@Test(priority=1)

	public void createProj() {
		
		File f1=new File("./src/test/resources/CreateProjBody.json");
	Response response= RestAssured.given()
		    .contentType(ContentType.JSON)
		    .body(f1)
		    
		 .when()
		    .post("http://49.249.28.218:8091/addProject");
		    
		  response.then().log().all();
		    
		    projectId=response.jsonPath().getString("projectId");
		    System.out.println("The project id is --"+projectId);
		    
		   
		
		    
	}
	@Test(priority = 2)
	public void getProj() {
		RestAssured.given()
		    .pathParam("projectId", projectId)
		
		.when()
		   .get("http://49.249.28.218:8091/project/{projectId}")
		   
		 .then().log().all();

	}
	@Test(priority = 3)
	public void update() {
		File f2=new File("./src/test/resources/UpdateBody.json");
		RestAssured.given()
		   .pathParam("projectId", projectId)
		   .contentType(ContentType.JSON)
		   .body(f2)
		   
		.when().put("http://49.249.28.218:8091/project/{projectId}")
		
		.then().log().all();
		
		
	}
	@Test(priority = 4)
	public void delete() {
		RestAssured.given()
		   .pathParam("projectId", projectId)
		   
		.when()
		  .delete("http://49.249.28.218:8091/project/{projectId}")
		  
		 
		.then().log().all();
		
		
	}

}
