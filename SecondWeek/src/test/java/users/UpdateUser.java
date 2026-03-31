package users;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateUser {
	

	@Test
	public void updateUser() {
		RestAssured.given().contentType(ContentType.JSON).pathParam("id",3)
		.body("{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"userName\": \"madhu\",\r\n"
				+ "  \"password\": \"1234567\"\r\n"
				+ "}")
		.when().put("https://fakerestapi.azurewebsites.net/api/v1/Users/{id}")
		.then().log().all()
		.assertThat()
		 .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .time(Matchers.lessThan(6000L));

	}
	
}
