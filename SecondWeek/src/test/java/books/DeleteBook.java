package books;

	import org.hamcrest.Matchers;

	import io.restassured.RestAssured;

public class DeleteBook {
	
		public void deleteBookbyid() {
			RestAssured.given().pathParam("id", 5)
			.when().delete("https://fakerestapi.azurewebsites.net/api/v1/Books/{id}")
			.then().log().all()
			.assertThat()
			  .statusCode(200)
			  .statusLine("HTTP/1.1 200 OK")
			  .time(Matchers.lessThan(6000l));
			
		
	}

}
