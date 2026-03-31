package requestBody;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Req_BodyFromFile {
	@Test
	public void testbody() {
		
		File f=new File("./src/test/resources/CreateProjBody.json");
		RestAssured.given()
		  .contentType(ContentType.JSON)
		  .body(f)
		  
		  .when().post("http://49.249.28.218:8091/addProject")
			
			.then().log().all();
	
		
		
	}

}
