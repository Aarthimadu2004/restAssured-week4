
package books;

	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
public class GetBookById {
	
		@Test
		public void getBookbyid() {
			RestAssured.given().pathParam("id", 5)
			.when().get("https://fakerestapi.azurewebsites.net/api/v1/Books/{id}")
			.then().log().all()
			.assertThat()
			  .statusCode(200)
			  .statusLine("HTTP/1.1 200 OK")
			  .header("Transfer-Encoding",Matchers.equalTo("chunked"))
			  .header("Server",Matchers.equalTo("Kestrel"))
			  .time(Matchers.lessThan(6000l));
			
		}
	
}
