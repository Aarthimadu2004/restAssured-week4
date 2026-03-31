package authors;

	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import static io.restassured.RestAssured.*;

public class GetAuthById {
	
		
		@Test
		public void getByid() {	
			given().pathParam("id",2)
			.when()
			.get("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}")
			.then().log().all()
			.assertThat()
			 .statusCode(200)
			 .statusLine("HTTP/1.1 200 OK")
			 .time(Matchers.lessThan(5000l))
			 .body("id",Matchers.equalTo(2))
			 .header("Transfer-Encoding",Matchers.equalTo("chunked"));
		}
	
}
