package users;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class DeleteUser {
	

	@Test
	public void delete_byid() {
		RestAssured.given().pathParam("id",2)
		.when().delete("https://fakerestapi.azurewebsites.net/api/v1/Users/{id}")
		.then().log().all()
		.assertThat()
		 .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .time(Matchers.lessThan(6000L));

	}
	
}
