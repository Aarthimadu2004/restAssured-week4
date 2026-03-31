package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Update {
	@Test
	public void update() {
		 given()
			. contentType(ContentType.JSON)
			   .body("{\r\n"
					    + "  \"createdBy\": \"Aarthi\",\r\n"
					    + "  \"projectName\": \"Blains\",\r\n"
					    + "  \"status\": \"Completed\",\r\n"
					    + "  \"teamSize\": 0\r\n"
					    + "}")
			   .pathParam("projectId", "NH_PROJ_143")
				
				.when().put("http://49.249.28.218:8091/project/{projectId}")
				
				.then()
				   .log().all()
				   .assertThat()
				      .statusCode(200)
				        .statusLine(containsString("HTTP"))
				          .time(lessThan(5000L))
				          .body(containsString("status"), containsString("Completed"))
				          .body(containsString("projectName"), containsString("NewWorld"));
	}

}
