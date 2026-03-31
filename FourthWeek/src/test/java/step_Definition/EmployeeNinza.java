package step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class EmployeeNinza {
	
	Response response;
	String empId;

	
	@Given("Base URI is set for emp")
	public void setURINinza() {
		RestAssured.baseURI="http://49.249.28.218:8091";
	}
	
	@When("I send POST request with {string}, {string}, {string}, {string}, {int}, {string}, {string}, {string}, {string}")
	public void prepareBody(String designation, String dob, String email, String empName,
	                        int experience, String mobileNo, String project,
	                        String role, String username) {

	    String body = "{\n" +
	            "  \"designation\": \"" + designation + "\",\n" +
	            "  \"dob\": \"" + dob + "\",\n" +
	            "  \"email\": \"" + email + "\",\n" +
	            "  \"empName\": \"" + empName + "\",\n" +
	            "  \"experience\": " + experience + ",\n" +
	            "  \"mobileNo\": \"" + mobileNo + "\",\n" +
	            "  \"project\": \"" + project + "\",\n" +
	            "  \"role\": \"" + role + "\",\n" +
	            "  \"username\": \"" + username + "\"\n" +
	            "}";
	    response=RestAssured.given()
		        .contentType(ContentType.JSON)
		        .body(body)
		   .when().post("/employees");
		empId=response.jsonPath().getString("employeeId");
		System.out.println(empId);
		
		
	    
	}
	@When("I send GET request for created employee")
    public void getEmployee() {
        response = RestAssured.given()
                .when()
                .get("/employees/" + empId);

        response.prettyPrint();
    }

    // ---------------- UPDATE ----------------
	   @When("I send PUT request with {string}, {string}, {string}, {string}, {int}, {string}, {string}, {string}, {string}")
	    public void updateEmployee(String designation, String dob, String email, String empName,
	                               int experience, String mobileNo, String project, String role, String username) {

	        String body = "{\n" +
	                "  \"designation\": \"" + designation + "\",\n" +
	                "  \"dob\": \"" + dob + "\",\n" +
	                "  \"email\": \"" + email + "\",\n" +
	                "  \"empName\": \"" + empName + "\",\n" +
	                "  \"experience\": " + experience + ",\n" +
	                "  \"mobileNo\": \"" + mobileNo + "\",\n" +
	                "  \"project\": \"" + project + "\",\n" +
	                "  \"role\": \"" + role + "\",\n" +
	                "  \"username\": \"" + username + "\"\n" +
	                "}";

	        response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(body)
	                .when()
	                .put("/employee/" + empId);

	       
	    }
    // ---------------- DELETE ----------------
    @When("I send DELETE request for employee")
    public void deleteEmployee() {
        response = RestAssured.given()
                .when()
                .delete("/employee/" + empId);

       
    }

  

    @Then("validate the empName as {string}")
    public void validate_name(String empName) {
        response.then().body("employeeName", equalTo(empName));
    }

 
	@Then("validate the status code {int} for emp")
	public void validateStatusCode(int code) {
		response.then().statusCode(code);
	}
	
	

}
