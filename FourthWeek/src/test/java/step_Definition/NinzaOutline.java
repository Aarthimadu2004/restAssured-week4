package step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NinzaOutline {
	Response response;
	String body;
	static String projectId;
	
	@Given("Base URI is set for NinzaHRM")
	public void setURINinza() {
		RestAssured.baseURI="http://49.249.28.218:8091";
	}
	
		 @Given("request body is prepared with {string}, {string}, {string}, {string} and")
		    public void prepareBody(String createdBy, String projectName, String status, String teamSize) {

		        body = "{\n" +
		                "  \"createdBy\": \"" + createdBy + "\",\n" +
		                "  \"projectName\": \"" + projectName + "\",\n" +
		                "  \"status\": \"" + status + "\",\n" +
		                "  \"teamSize\": " + teamSize + "\n" +
		                "}";

		       
		    }

		    @When("I send POST request to {string}")
		    public void sendPostRequest(String endpoint) {
		    	 response = RestAssured.given()
			                .contentType(ContentType.JSON)
			                .body(body)
			                .when()
			                .post("/addProject");
		    }

		    @Then("response status should be {int}")
		    public void validateStatus(int statusCode) {
		        response.then().statusCode(statusCode);
		    }

		    
		

	
	

}
