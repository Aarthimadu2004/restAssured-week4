package petStore;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import java.util.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojoClasses.CreatePet;

public class CreatePojo {

	@Test
	public void create() {
		CreatePet.Category category = new CreatePet.Category(1, "Cat");
		CreatePet.Tag tag = new CreatePet.Tag(1, "Friendly");

		List<String> photoUrls = Arrays.asList("url1");
		List<CreatePet.Tag> tags = Arrays.asList(tag);

		CreatePet pets = new CreatePet(0, category, "kitty", photoUrls, tags, "available");
		
		RestAssured.given()
		   .contentType(ContentType.JSON)
		   .body(pets)
		   
		.when().post("https://petstore.swagger.io/v2/pet")
		
		.then().log().all()
		   .assertThat()
		      .statusCode(200)
		        .statusLine(Matchers.containsString("HTTP"))
		          .time(Matchers.lessThan(5000L))
		             .body(Matchers.containsString("name"),Matchers.containsString("dog"));
		   
	}
}
