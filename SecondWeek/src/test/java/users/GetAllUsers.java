package users;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllUsers {
	

	@Test
	public void get_all_User() {
		RestAssured.given()
		.when().get("https://fakerestapi.azurewebsites.net/api/v1/Users")
		.then().log().all()
		.assertThat()
		 .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .time(Matchers.lessThan(6000L));

	}
	

}
