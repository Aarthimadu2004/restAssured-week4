package activities;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetSingActi {
	
	@Test
	public void getByid() {
		RestAssured.given().pathParam("id","2")
		.when().get("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}")
	    .then().log().all()
	    .assertThat()
	      .statusCode(200)
	      .statusLine("HTTP/1.1 200 OK")
	      .time(Matchers.lessThan(6000l))
	      .header("api-supported-versions",Matchers.equalTo("1.0"));
	}
	

}
