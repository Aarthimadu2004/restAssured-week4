package activities;



import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetActi {

	@Test
	public void getall() {
		given()
		.when().get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.time(Matchers.lessThan(5000l))
		.header("Transfer-Encoding",Matchers.equalTo("chunked"));
	}
	

}
