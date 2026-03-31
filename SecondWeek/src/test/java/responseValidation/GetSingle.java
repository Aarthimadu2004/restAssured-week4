package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetSingle {
	@Test
	public void get() {
		  given()
		    .pathParam("projectId", "NH_PROJ_284")
			
			.when().get("http://49.249.28.218:8091/project/{projectId}")
			
			.then()
			   .log().all()
			   .assertThat()
			      .statusCode(200)
			        .statusLine(containsString("HTTP/1.1 200"))
			          .time(lessThan(5000L)).and()
			            .body(containsString("createdBy"), containsString("Aarthi"));
			           
			            
			            
		     
	}
	
	

}
