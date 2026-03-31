package petStore;
import static org.hamcrest.Matchers.containsString;

import static org.hamcrest.Matchers.lessThan;



import io.restassured.RestAssured;


public class DeleteAPEt {

		public static void main(String[] args) {
			
		
			RestAssured.given().pathParam("id", "9223372036854775807")
			.when()
			.delete("https://petstore.swagger.io/v2/pet/{id}")
			.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.time(lessThan(3000L));

			
		}
	
}
