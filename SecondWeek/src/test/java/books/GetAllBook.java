
package books;

	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
public class GetAllBook {

	@Test
	public void getBooks() {
		RestAssured.given()
		.when().get("https://fakerestapi.azurewebsites.net/api/v1/Books")
		.then().log().all()
		.assertThat()
		  .statusCode(200)
		  .statusLine("HTTP/1.1 200 OK")
		  .header("Transfer-Encoding",Matchers.equalTo("chunked"))
		  .header("Server",Matchers.equalTo("Kestrel"))
		  .time(Matchers.lessThan(6000l));
		
	}
	
}
