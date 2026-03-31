package cover;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class GetAllPhotos {

	@Test
	public void get_all_Photos() {

	RestAssured.given()
	.when()
	    .get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos")
	.then()
	    .log().all()
	    .assertThat()
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 OK")
	    .time(Matchers.lessThan(6000L));

	}
	

}
