package step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Petstore {
	
	Response response;
	static long petId;
	
	//CREATE
	@Given("Base URI is set")
	public void setURI() {
		RestAssured.baseURI="https://petstore.swagger.io/v2";
	}
	
	@When("I send post request with name \"Max\"")
	public void createPet(){
		String body = "{\n" +
		        "  \"id\": 0,\n" +
		        "  \"category\": {\n" +
		        "    \"id\": 0,\n" +
		        "    \"name\": \"string\"\n" +
		        "  },\n" +
		        "  \"name\": \"Max\",\n" +
		        "  \"photoUrls\": [\n" +
		        "    \"string\"\n" +
		        "  ],\n" +
		        "  \"tags\": [\n" +
		        "    {\n" +
		        "      \"id\": 0,\n" +
		        "      \"name\": \"string\"\n" +
		        "    }\n" +
		        "  ],\n" +
		        "  \"status\": \"available\"\n" +
		        "}";
		
		response=RestAssured.given()
				  .contentType(ContentType.JSON)
				  .body(body)
				  
				.when().post("/pet");
		
	petId=response.jsonPath().getLong("id");
		System.out.println(petId);
		
	}
	
	
	@When("I send GET request with petId")
    public void getPet() {
        response = RestAssured.given()
                .when()
                .get("/pet/"+petId);
    }
	
	
	@When("I send PUT request to update pet")
	public void updatePet(){
		String body = "{\n" +
		        "  \"id\": 0,\n" +
		        "  \"category\": {\n" +
		        "    \"id\": 0,\n" +
		        "    \"name\": \"string\"\n" +
		        "  },\n" +
		        "  \"name\": \"Max\",\n" +
		        "  \"photoUrls\": [\n" +
		        "    \"string\"\n" +
		        "  ],\n" +
		        "  \"tags\": [\n" +
		        "    {\n" +
		        "      \"id\": 0,\n" +
		        "      \"name\": \"string\"\n" +
		        "    }\n" +
		        "  ],\n" +
		        "  \"status\": \"sold\"\n" +
		        "}";
		
		response=RestAssured.given()
				  .contentType(ContentType.JSON)
				  .body(body)
				  
				.when().put("/pet");
	}
	
    @When("I send DELETE request with petId")
    public void deletePet() {
        response = RestAssured.given()
                .when()
                .delete("/pet/"+petId);
    }
	
	
	@Then("response code must be 200")
	public void validateStatusCode() {
		response.then().statusCode(200);
	}
	
	
	
	
	
}