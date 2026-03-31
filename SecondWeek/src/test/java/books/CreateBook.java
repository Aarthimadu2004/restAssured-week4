package books;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBook {
	
	@Test
	public void postBook() {
		RestAssured.given().contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"title\": \"Mind power\",\r\n"
				+ "  \"description\": \"goodstory\",\r\n"
				+ "  \"pageCount\": 0,\r\n"
				+ "  \"excerpt\": \"string\",\r\n"
				+ "  \"publishDate\": \"2026-03-12T03:36:31.416Z\"\r\n"
				+ "}")
		.when().post("https://fakerestapi.azurewebsites.net/api/v1/Books")
		.then().log().all()
		.assertThat()
		  .statusCode(200)
		  .statusLine("HTTP/1.1 200 OK")
		  .header("Transfer-Encoding",Matchers.equalTo("chunked"))
		  .header("Server",Matchers.equalTo("Kestrel"))
		  .time(Matchers.lessThan(6000l));
		
	}
	

}
