package petStore;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class UpdateApet {

	
		@Test
		public void update() {

		    

		    HashMap<Object,Object> pet = new HashMap<>();

		    HashMap<String,Object> category = new HashMap<>();
		    category.put("id",0);
		    category.put("name","dog");

		    List<String> photoUrls = new ArrayList<>();
		    photoUrls.add("string");
		    
		    HashMap<String,Object> tag = new HashMap<>();
		    tag.put("id",0);
		    tag.put("name","doggie");

		    List<HashMap<String,Object>> tags = new ArrayList<>();
		    tags.add(tag);


		    pet.put("id",0);
		    pet.put("category",category);
		    pet.put("name","taisen");
		    pet.put("photoUrls",photoUrls);
		    pet.put("tags",tags);
		    pet.put("status","available");

		    RestAssured.given()
		    .contentType(ContentType.JSON)
		    .body(pet)
		    .when()
		    .put("https://petstore.swagger.io/v2/pet")
		    .then()
		    .log().all()
		    .assertThat()
		    .statusCode(200)
		    .statusLine(containsString("HTTP"))
		    .time(lessThan(15000L));
		}
	
	
}
