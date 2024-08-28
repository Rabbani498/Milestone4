package milestone4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestingRestAPI {
  @Test(priority = 2)
  public void createUser() {
	  
	  System.out.println("******create user*****");
	  
	  String reqBody = "{\n"
	  		+ "    \"name\": \"rabbani\",\n"
	  		+ "    \"job\": \"tester\"\n"
	  		+ "}"; 
	  given()
	    .body(reqBody)
	    .log().all()
	  .when()
	    .post("/api/users/")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(201);
  }
  @Test(priority = 1)
  public void getAllUsers() {
	  
	  System.out.println("*******get all users*****");
	  
	  given()
	    .log().all()
	  .when()
	    .get("/api/users?page=2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 3)
  public void putUser() {
	  
	  System.out.println("******put user******");
	  
	  String reqBody = "{\n"
	  		+ "    \"name\": \"shaik\",\n"
	  		+ "    \"job\": \"tester\"\n"
	  		+ "}";
	  given()
	  .body(reqBody)
	    .log().all()
	  .when()
	    .put("/api/users/2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 4)
  public void patchUser() {
	  
	  System.out.println("*******patch user******");
	  
	  String reqBody = "{\n"
	  		+ "    \"name\": \"rabbani-updated\",\n"
	  		+ "}";
	  given()
	  .body(reqBody)
	    .log().all()
	  .when()
	    .patch("/api/users/2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 5)
  public void deleteUser() {
	  
	  System.out.println("*********delete user********");
	 
	  given()
	    .log().all()
	  .when()
	    .delete("/api/users/2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(204);
  }
  
	@BeforeClass
	public void setUp() {
		baseURI = "https://reqres.in/";
	}
}
