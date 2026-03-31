package authors;



	import org.hamcrest.Matchers;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;

public class DeleteAuth{
		@Test
		public void getByid() {	
			RestAssured.given().pathParam("id",2).contentType(ContentType.JSON)
			.when()
			.delete("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}")
			.then().log().all()
			.assertThat()
			 .statusCode(200)
			 .statusLine("HTTP/1.1 200 OK")
			 .time(Matchers.lessThan(5000l));
		}
	
}
