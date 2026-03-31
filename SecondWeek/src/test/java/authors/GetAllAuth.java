
package authors;

	import org.hamcrest.Matchers;

	import io.restassured.RestAssured;
public class GetAllAuth {



	public static void main(String[] args) {
		
		
			RestAssured.given()
			.when()
			.get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
			.then().log().all()
			.assertThat()
			 .statusCode(200)
			 .statusLine("HTTP/1.1 200 OK")
			 .time(Matchers.lessThan(5000l))
			 .header("Transfer-Encoding",Matchers.equalTo("chunked"));
		}
		
	
}
