package parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UpdatePet_FormParam {
	@Test
	public void updatePet() {
		RestAssured.given()
		   .pathParam("petId", 540)
		   .formParam("name", "andy")
		   .formParam("status", "sold")
		
		.when().get("https://petstore.swagger.io/v2/pet/{petId}")
		
		.then().log().all();
	}

}
