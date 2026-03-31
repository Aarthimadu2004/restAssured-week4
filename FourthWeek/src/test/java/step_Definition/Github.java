package step_Definition;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Github {
	Response response;
	static String repoName;
	static String owner="Aarthimadu2004";
	
	@Given("Base URI is set for github")
	public void setURI() {
		RestAssured.baseURI="https://api.github.com";
	}
	
	@When("I send POST request with with repoName {string}")
	public void createRepo(String name) {
		repoName=name;
		String body = "{\n" +
		        "  \"name\": \"Proj2\",\n" +
		        "  \"description\": \"sample repository\"\n" +
		        "}";
		
		response=RestAssured.given()
				.auth().oauth2("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")
				.contentType(ContentType.JSON)
				    .body(body)
				    
				.when().post("/user/repos");
		
		
				    
	}
	@When("I send GET request for github")
	public void getRepo() {
		response=RestAssured.given()
				.auth().oauth2("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")
				   .pathParam("repoName",repoName)
				   .pathParam("owner", owner)
				.when().get("/repos/{owner}/{repoName}");
	}
	
	@When("I send PUT request with description \"New file\"")
	public void putRepo() {
		String body = "{\n" +
		        "  \"name\": \"Proj2\",\n" +
		        "  \"description\": \"New file\"\n" +
		        "}";
		
		response=RestAssured.given()
				.auth().oauth2("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")
				.contentType(ContentType.JSON)
				    .body(body)
				    .pathParam("repoName",repoName)
					  .pathParam("owner", owner)

				    
				.when().patch("/repos/{owner}/{repoName}");
	}
	@When("I send DELETE request for github")
	public void deleteRepo() {
		response=RestAssured.given()
				.auth().oauth2("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")
				   .pathParam("repoName",repoName)
				   .pathParam("owner", owner)
				.when().delete("/repos/{owner}/{repoName}");
	}
	
	@Then("response code must be {int} for github")
	public void validateStatusCode(int code) {
		response.then().statusCode(code);
	}
	
//	@Then("repo name should be {string}")
//	public void name(String name) {
//		response.then().body("name", Matchers.equalTo(name));
//	}

}
