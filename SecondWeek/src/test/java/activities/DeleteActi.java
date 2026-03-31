package activities;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
public class DeleteActi{

	@Test
	public void delete() {
		given().pathParam("id",2)
		.when().delete("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.time(Matchers.lessThan(5000l))
		.header("Content-Length",Matchers.equalTo("0"));
	}
	
}
