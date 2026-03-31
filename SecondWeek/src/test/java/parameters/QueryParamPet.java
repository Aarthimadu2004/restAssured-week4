package parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class QueryParamPet {
	@Test
	public void petStore() {
		RestAssured.given()
		  .queryParam("status", "sold")
		  
		
	    .when().get("https://petstore.swagger.io/v2/pet/findByStatus")
	    
	    .then().log().all();
	}

}

//id=9223372036854775458
