package authentication;



import static io.restassured.RestAssured.*;

public class Bearer {
	public static void main(String[] args) {
		
	
		given()
		  .auth().oauth2("1234")
		
		.when().get("https://httpbin.org/bearer")
		
		.then().log().all();
		  
		 
	}


}
