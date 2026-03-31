package cover;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class UpdateCover {


	@Test
	public void post_Photos() {

	RestAssured.given().pathParam("id",3)
	    .contentType(ContentType.JSON)
	    .body("{\r\n"
	            + "  \"id\": 2,\r\n"
	            + "  \"idBook\": 13,\r\n"
	            + "  \"url\": \"https://openlibrary.org/books/OL7251393M/The_Secret_Agent\"\r\n"
	            + "}")
	.when()
	    .put("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/{id}")
	.then()
	    .log().all()
	    .assertThat()
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 OK")
	    .time(Matchers.lessThan(6000L));
	}

		
	

}
