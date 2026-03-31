package authors;

	import static io.restassured.RestAssured.given;

	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

public class GetAuthBy_BookId {
	
		@Test
		public void getBybookid() {	
			given().pathParam("idBook",1)
			.when()
			.get("https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/{idBook}")
			.then().log().all()
			.assertThat()
			 .statusCode(200)
			 .statusLine("HTTP/1.1 200 OK")
			 .time(Matchers.lessThan(5000l))

			
			 .header("Transfer-Encoding",Matchers.equalTo("chunked"));
		}
	
}
