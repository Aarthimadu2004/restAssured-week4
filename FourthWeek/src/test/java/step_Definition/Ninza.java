package step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Ninza {
	
	Response response;
	static String projectId;
	
	@Given("Base URI is set for Ninza")
	public void setURINinza() {
		RestAssured.baseURI="http://49.249.28.218:8091";
	}
	
	@When("I send POST request with projectName \"Sky1\"")
	public void createProj() {
		String body = "{\"createdBy\":\"Aarthi\",\"projectName\":\"Sky1\",\"status\":\"Created\",\"teamSize\":0}";
		
		response=RestAssured.given()
		        .contentType(ContentType.JSON)
		        .body(body)
		   .when().post("/addProject");
		projectId=response.jsonPath().getString("projectId");
		System.out.println(projectId);
	}
	
	
	
	
	
	@When("I send GET request")
	public void  getProj() {
		response = RestAssured.given()
				    .pathParam("id", projectId)
				       
                .when()
                .get("/project/{id}");
	}
	
	@When("I send PUT request with status \"Completed\"")
    public void updateProject() {

        String body = "{\n" +
                "  \"createdBy\": \"Aarthi\",\n" +
                "  \"projectName\": \"Sky1\",\n" +
                "  \"status\": \"Completed\",\n" +
                "  \"teamSize\": 0\n" +
                "}";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
        
                .put("/project/" + projectId);
    }
	
	@When("I send DELETE request")
	public void delete() {
		response = RestAssured.given()
			       
         .when()
         .delete("/project/"+projectId);
	}
	
	@Then("response code must be {int} for ninza")
	public void validateStatusCode(int code) {
		response.then().statusCode(code);
	}

	

}
