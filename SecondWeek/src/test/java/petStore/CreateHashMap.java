package petStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matcher.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateHashMap {
	@Test
	public void createPet() {
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", 0);
		
		HashMap<String,Object> category=new HashMap<String, Object>();
		map.put("id", 0);
		map.put("name", "dog");
		map.put("category", category);
		
		map.put("name", "tom");
		
		List<String> photo=new ArrayList<String>();
		photo.add("./src/test/resources/dog.jpg");
		map.put("photoUrls", photo);
		
		List<HashMap<String, Object>> tag=new ArrayList();
		HashMap<String, Object> map1=new HashMap<String, Object>();
		map1.put("id", 0);
		map1.put("name", "dog");
		tag.add(map1);
		map.put("tags", tag);
		map.put("status", "available");
		
		
		
		RestAssured.given()
		   .contentType(ContentType.JSON)
		   .body(map)
		
		.when()
		    .post("https://petstore.swagger.io/v2/pet")
		    
		.then().log().all()
		   .assertThat()
		      .statusCode(200)
		        .statusLine(Matchers.containsString("HTTP"))
		          .time(Matchers.lessThan(5000L))
		             .body(Matchers.containsString("name"),Matchers.containsString("dog"));
	}

}
