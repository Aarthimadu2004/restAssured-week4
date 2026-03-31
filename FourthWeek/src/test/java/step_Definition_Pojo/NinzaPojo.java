package step_Definition_Pojo;

import cucumber.Nninza_pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NinzaPojo {
	
	Response response;
	String body;
	static String projectId;
	
	@Given("Base URI is set for NinzaHRM application")
	public void setURINinza() {
		RestAssured.baseURI="http://49.249.28.218:8091";
	}
	

		    @When("request body is prepared with {string}, {string}, {string}, {string}")
		    public void sendPostRequest(String createdBy, String projectName, String status, String teamSize) {
		    	Nninza_pojo obj=new Nninza_pojo();
		         obj.setCreatedBy(createdBy);
		         obj.setProjectName(projectName);
		         obj.setStatus(status);
		         obj.setTeamSize(teamSize);
		    	response = RestAssured.given()
			                .contentType(ContentType.JSON)
			                .body(obj)
			                .when()
			                .post("/addProject");
		    }

		    @Then("response status should be {int} for this")
		    public void validateStatus(int statusCode) {
		        response.then().statusCode(statusCode);
		    }

		    
		


}
