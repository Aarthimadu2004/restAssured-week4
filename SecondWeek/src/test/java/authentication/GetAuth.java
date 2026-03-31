package authentication;




import static io.restassured.RestAssured.*;

public class GetAuth {

	public static void main(String[] args) {
	
	
		given()
		  .pathParam("user", "admin")
		  .pathParam("passwd", "123")
		  .auth().basic("admin", "123")
		  
		.when().get("https://httpbin.org/basic-auth/{user}/{passwd}")
		
		
		.then().log().all();
	}
	
}
