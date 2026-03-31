package step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FakeRest {

	Response response;
	
	
	@Given("Base URI is set for Fake")
	public void setURIFake() {
		RestAssured.baseURI="https://fakerestapi.azurewebsites.net";
		
	}
	
	
	@When("I send post request with title \"Mag\"")
	public void createAct() {
		String body = "{\n" +
		        "  \"id\": 0,\n" +
		        "  \"title\": \"Mag\",\n" +
		        "  \"dueDate\": \"2026-03-24T07:27:30.203Z\",\n" +
		        "  \"completed\": false\n" +
		        "}";
		
		response=RestAssured.given()
				    .contentType(ContentType.JSON)
				    .body(body)
				    
				 .when().post("/api/v1/Activities");
	
	}
	
	@When("I send get request")
	public void getAct() {
		response=RestAssured.given()
				    .when().get("/api/v1/Activities/2");
	}
	
	@When("I send put request")
	public void updateAct() {
		String body = "{\n" +
		        "  \"id\": 2,\n" +
		        "  \"title\": \"Mag\",\n" +
		        "  \"dueDate\": \"2026-03-24T07:27:30.203Z\",\n" +
		        "  \"completed\": true\n" +
		        "}";
		
		response=RestAssured.given()
				    .contentType(ContentType.JSON)
				    .body(body)
				    
				 .when().put("/api/v1/Activities/2");
	}
	
	@When("I send delete request")
	public void deleteAct() {
		response=RestAssured.given()
				    .when().delete("/api/v1/Activities/2");
	}
	
	@Then("validate the status code 200")
	public void statusCode(){
		response.then().statusCode(200);
	}
	
}
