package requestBody;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojoClasses.CreatePro;

public class ReqBody_FromPOJO {
	@Test
	public void createProj() {
		CreatePro obj=new CreatePro();
		obj.setCreatedBy("Aarthi");
		obj.setProjectName("browniez");
		obj.setStatus("Completed");
		obj.setTeamSize(0);
		
		RestAssured.given()
		   .contentType(ContentType.JSON)
		    .body(obj)
		
		.when().post("http://49.249.28.218:8091/addProject")
		
		.then().log().all();
	}
	

}
