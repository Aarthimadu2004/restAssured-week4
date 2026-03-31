package authors;

	import static io.restassured.RestAssured.given;

	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;

public class UpdateAuth {

		@Test
		public void update() {	
			given().pathParam("id",3).contentType(ContentType.JSON).body("{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"idBook\": 111,\r\n"
				+ "  \"firstName\": \"blue\",\r\n"
				+ "  \"lastName\": \"vat\"\r\n"
				+ "}")
			.when()
			.put("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}")
			.then().log().all()
			.assertThat()
			 .statusCode(200)
			 .statusLine("HTTP/1.1 200 OK")
			 .time(Matchers.lessThan(5000l))
			 .body("id",Matchers.equalTo(2))
			 .header("Transfer-Encoding",Matchers.equalTo("chunked"));
		}
	
}
