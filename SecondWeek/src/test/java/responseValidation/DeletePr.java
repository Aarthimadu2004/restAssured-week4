package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletePr {
	@Test
	public void del() {
		given()
		 .pathParam("projectId", "NH_PROJ_045")
		
		.when().delete("http://49.249.28.218:8091/project/{projectId}")
		
		.then()
		 .log().all()
		    .assertThat()
		       .statusCode(204)
		         .statusLine(containsString("HTTP"))
		           .time(lessThan(5000L));
		          
	}

}
