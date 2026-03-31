package githubCRUD;

import java.io.File;
import java.util.regex.Matcher;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GithubPrac {
	static String owner="Aarthimadu2004";
	String repoName;
	@Test(priority=1)
	public void createRepo() {
		File f1=new File("./src/test/resources/RepoBody.json");
	Response response=RestAssured.given()
		  .auth().oauth2("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")
		  .contentType(ContentType.JSON)
		  .body(f1)
		
		.when().post("https://api.github.com/user/repos");
		
		
		
		response.then().log().all().assertThat()
		    .statusCode(201)
		      .statusLine(containsString("HTTP"))
		        .time(lessThan(5000L))
		          .body(containsString("name"), containsString(repoName));
		 repoName=response.jsonPath().getString("name");
	
  

	}
	@Test(priority=2)
	public void getRepo() {
		RestAssured.given()
		.auth().oauth2("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")
		  .pathParam("owner", owner)
		  .pathParam("repoName",repoName )
		
		.when().get("https://api.github.com/repos/{owner}/{repoName}")
		
		.then().log().all().assertThat()
	    .statusCode(200)
	      .statusLine(containsString("HTTP"))
	        .time(lessThan(5000L));
		    
		
	}
	@Test(priority=3)
	public void update() {
		File f2=new File("./src/test/resources/RepoUpdate.json");
		RestAssured.given()
		.auth().oauth2("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")
		  .pathParam("owner", owner)
		  .pathParam("repoName",repoName)
		  .contentType(ContentType.JSON)
		  .body(f2)
		
		.when().patch("https://api.github.com/repos/{owner}/{repoName}")
		

		.then().log().all().assertThat()
	    .statusCode(200)
	      .statusLine(containsString("HTTP"))
	        .time(lessThan(5000L))
	        .body(containsString("name"), containsString(repoName));
		
	}
	@Test(priority=4)
	public void delete() {
		RestAssured.given()
		.auth().oauth2("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")
		  .pathParam("owner", owner)
		  .pathParam("repoName",repoName)
		  
		  
		.when().delete("https://api.github.com/repos/{owner}/{repoName}")
		
		.then().log().all().assertThat()
	    .statusCode(204)
	      .statusLine(containsString("HTTP"))
	        .time(lessThan(5000L));
	}
	

}
