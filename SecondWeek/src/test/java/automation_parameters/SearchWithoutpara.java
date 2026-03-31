package automation_parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SearchWithoutpara {
	@Test
	public void search() {
		RestAssured.given()
		    
		
		.when().post("https://automationexercise.com/api/searchProduct")
		
		.then().log().all();
		
	}

}
