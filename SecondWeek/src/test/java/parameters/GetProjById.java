package parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetProjById {
	@Test
	
	public void getProi() {
		RestAssured.given()
		  .pathParam("projectId", "NH_PROJ_007")
		
		
		.when().get("http://49.249.28.218:8091/project/{projectId}")
		
		.then().log().all();
	}

}
