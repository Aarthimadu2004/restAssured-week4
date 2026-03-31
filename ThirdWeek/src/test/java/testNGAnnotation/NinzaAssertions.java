package testNGAnnotation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NinzaAssertions {
	String projectId;
	@Test(priority=1)
	public void addProjTest() {
		Response res= RestAssured.given()
		   .contentType(ContentType.JSON)
		     .body("{\r\n"
		     		+ "  \"createdBy\": \"Aarthi\",\r\n"
		     		+ "  \"projectName\": \"NewProj_1\",\r\n"
		     		+ "  \"status\": \"Created\",\r\n"
		     		+ "  \"teamSize\": 0\r\n"
		     		+ "}")
		     
		 .when().post("http://49.249.28.218:8091/addProject");
		
		 projectId=res.jsonPath().getString("projectId");
		 
		 Assert.assertEquals(res.getStatusCode(), 201);
		 Assert.assertEquals(res.jsonPath().getString("createdBy"), "Aarthi");
		 Assert.assertEquals(res.jsonPath().getString("projectName"), "NewProj_1");
		 Assert.assertEquals(res.jsonPath().getString("status"), "Created");

		 Assert.assertTrue(res.getTime()<5000);
		 Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 201 ");
		 
	}
	
	@Test(priority=2)
	public void getProjTest() {
		Response res=RestAssured.given()
		   .pathParam("projectId", projectId)
		
		.when().get("http://49.249.28.218:8091/project/{projectId}");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		 Assert.assertTrue(res.getTime()<5000);
		Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 ");	
		
	}
	
	@Test(priority=3)
	public void updateProjTest() {
		Response res= RestAssured.given()
				.pathParam("projectId", projectId)
				   .contentType(ContentType.JSON)
				     .body("{\r\n"
				     		+ "  \"createdBy\": \"Aarthi\",\r\n"
				     		+ "  \"projectName\": \"NewProj_1\",\r\n"
				     		+ "  \"status\": \"Completed\",\r\n"
				     		+ "  \"teamSize\": 0\r\n"
				     		+ "}")
	     .when().put("http://49.249.28.218:8091/project/{projectId}");
		
		 Assert.assertEquals(res.getStatusCode(), 200);
		 Assert.assertEquals(res.jsonPath().getString("status"), "Completed");
		 Assert.assertEquals(res.jsonPath().getString("createdBy"), "Aarthi");
		 Assert.assertEquals(res.jsonPath().getString("projectName"), "NewProj_1");
		 Assert.assertTrue(res.getTime()<5000);
	     Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 ");
		
	}
	
	@Test(priority=4)
	public void deleteProjTest() {
		Response res=RestAssured.given()
				   .pathParam("projectId", projectId)
				
				.when().delete("http://49.249.28.218:8091/project/{projectId}");
		Assert.assertEquals(res.getStatusCode(), 204);
		 Assert.assertTrue(res.getTime()<5000);
		 Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 204 ");	
	}

}
