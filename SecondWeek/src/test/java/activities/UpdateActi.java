
package activities;

	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
public class UpdateActi {
	


			@Test
			public void update_byid() {
				RestAssured.given().pathParam("id","3").contentType(ContentType.JSON)
				.body("{\r\n"
						+ "  \"id\": 2,\r\n"
						+ "  \"title\": \"hats\",\r\n"
						+ "  \"dueDate\": \"2026-03-12T03:00:58.119Z\",\r\n"
						+ "  \"completed\": false\r\n"
						+ "}")
				.when().put("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}")
			    .then().log().all()
			    .assertThat()
			      .statusCode(200)
			      .statusLine("HTTP/1.1 200 OK")
			      .time(Matchers.lessThan(6000l))
			      .header("api-supported-versions",Matchers.equalTo("1.0"));
			}
			
}
