package responseValidation;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePr {
	public static void main(String[] args) {
		
	
		 given()
		. contentType(ContentType.JSON)
		   .body("{\r\n"
				    + "  \"createdBy\": \"Aarthi\",\r\n"
				    + "  \"projectName\": \"NewWorld\",\r\n"
				    + "  \"status\": \"Created\",\r\n"
				    + "  \"teamSize\": 0\r\n"
				    + "}")
			
			.when().post("http://49.249.28.218:8091/addProject")
			
			.then()
			   .log().all()
			   .assertThat()
			      .statusCode(201)
			        .statusLine(containsString("HTTP/1.1 201"))
			          .time(lessThan(5000L))
			          .body(containsString("status"), containsString("Created"))
			          .body(containsString("projectName"), containsString("NewWorld"));
		                
	
		
	}

}
