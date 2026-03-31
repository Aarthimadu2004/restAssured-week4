package activities;
	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;

public class CreateActi {

	@Test
	public void post() {
		RestAssured.given().contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"title\": \"hat\",\r\n"
				+ "  \"dueDate\": \"2026-03-12T02:34:37.585Z\",\r\n"
				+ "  \"completed\": true\r\n"
				+ "}")
		.when().post("https://fakerestapi.azurewebsites.net/api/v1/Activities")
	     .then()
	     .log().all()
	     .assertThat()
	     .statusCode(200).statusLine("HTTP/1.1 200 OK")
	     .time(Matchers.lessThan(8000l))
	     .body("title",Matchers.equalTo("hat"))
	     .header("Server",Matchers.equalTo("Kestrel"));
	}
	
}
