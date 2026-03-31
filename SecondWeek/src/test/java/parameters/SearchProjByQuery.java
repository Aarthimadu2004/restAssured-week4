package parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SearchProjByQuery {
	@Test
	public void search() {
		RestAssured.given()
		.queryParam("projectId", "NH_PROJ_007")
		
		
		.when().post("http://49.249.28.218:8091/project")
		
		.then().log().all();
	}

}
