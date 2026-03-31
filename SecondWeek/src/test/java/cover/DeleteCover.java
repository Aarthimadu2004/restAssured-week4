package cover;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteCover {

			@Test

			public void get_by_id() {

			RestAssured.given().pathParam("id",2)
			.when()
			    .get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/{id}")
			.then()
			    .log().all()
			    .assertThat()
			    .statusCode(200)
			    .statusLine("HTTP/1.1 200 OK")
			    .time(Matchers.lessThan(6000L));

			}
	
}
