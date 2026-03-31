package parameters;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UploadImg_FormParam {
	@Test
	public void img() {
		
		File f1=new File("./src/test/resources/dog.jpg");
		RestAssured.given()
		  .pathParam("petId", 540)
		  .formParam("additionalMetadata", "Image of the dog")
		  .multiPart("file",f1)
		
		.when().post("https://petstore.swagger.io/v2/pet/{petId}/uploadImage")
		
		.then().log().all();
	}

}
