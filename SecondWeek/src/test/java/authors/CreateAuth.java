
package authors;

	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
public class CreateAuth {
	
	@Test
	public void post_authors() {
		RestAssured.given().contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"idBook\": 11,\r\n"
				+ "  \"firstName\": \"Blue\",\r\n"
				+ "  \"lastName\": \"man\"\r\n"
				+ "}")
		.when()
		.post("https://fakerestapi.azurewebsites.net/api/v1/Authors")
		.then().log().all()
		.assertThat()
		 .statusCode(200)
		 .statusLine("HTTP/1.1 200 OK")
		 .time(Matchers.lessThan(5000l))
		 .body("id",Matchers.equalTo(2))
		 .body("firstName",Matchers.equalTo("Blue"));
		
	
	}
}
