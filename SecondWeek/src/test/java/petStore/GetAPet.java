package petStore;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class GetAPet {
	

	public class getAPet {
	@Test
	public void get() {
		RestAssured.given().pathParam("id", "9223372036854775807")
		.when()
		.get("https://petstore.swagger.io/v2/pet/{id}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.statusLine(containsString("HTTP"))
		.time(lessThan(5000L));

		
	}
	}

}
