package users;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUser {
	
	@Test
	public void postUser() {
		RestAssured.given().contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"userName\": \"aarthi\",\r\n"
				+ "  \"password\": \"12345678\"\r\n"
				+ "}")
		.when().post("https://fakerestapi.azurewebsites.net/api/v1/Users")
		.then().log().all()
		.assertThat()
		 .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .time(Matchers.lessThan(6000L));

	
	}

}
