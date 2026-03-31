package requestBody;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BodyUsingHashmap {
	public static void main(String[] args) {
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("createdBy","Aarthi" );
		map.put("projectName", "Blink");
		map.put("status", "Created");
		map.put("teamSize", 0);
		
		RestAssured.given()
		  .contentType(ContentType.JSON)
		  .body(map)
		
		.when().post("http://49.249.28.218:8091/addProject")
		
		.then().log().all();
	}

}
