package requestBody;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ReqBody_FromMethod {
	public static void main(String[] args) {

		RestAssured.given()
		  .contentType(ContentType.JSON)
		  .body(Payload.CreateProject())
		
		.when().post("http://49.249.28.218:8091/addProject")
		
		.then().log().all();
	}

}
