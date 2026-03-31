package books;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class UpdateBook{
		@Test
		public void postBook() {
			RestAssured.given().contentType(ContentType.JSON).pathParam("id",3)
			.body("{\r\n"
					+ "  \"id\": 2,\r\n"
					+ "  \"title\": \"Mind power\",\r\n"
					+ "  \"description\": \"really mind blowing book- subconsious power  \",\r\n"
					+ "  \"pageCount\": 0,\r\n"
					+ "  \"excerpt\": \"string\",\r\n"
					+ "  \"publishDate\": \"2026-03-12T03:36:31.416Z\"\r\n"
					+ "}")
			.when().put("https://fakerestapi.azurewebsites.net/api/v1/Books/{id}")
			.then().log().all()
			.assertThat()
			  .statusCode(200)
			  .statusLine("HTTP/1.1 200 OK")
			  .header("Transfer-Encoding",Matchers.equalTo("chunked"))
			  .header("Server",Matchers.equalTo("Kestrel"))
			  .time(Matchers.lessThan(6000l));
			
	
	}
}
