package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class E_commerce {
	public String accessToken;
	public String id;
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	// it will not execute that method
	@Test ( priority = 0, enabled= false)
	public void sign_up()
	{
		RestAssured.baseURI = baseurl;
		 String requestbody = "{\r\n"
		 		+ "	\"email\": \"Sanjana46507@gmail.com\",\r\n"
		 		+ "	\"password\": \"sanjana@123\"\r\n"
		 		+ "}\r\n"
		 		+ "";
		 
		 //This time i want to know what my response is in my console
		 Response response = given()
				 .header("content-Type","application/json")
				 .body(requestbody)
				 
				 .when()
				 .post("/user/signup")
				 
				 .then()
				 .assertThat().statusCode(201).contentType(ContentType.JSON)
				 //to extract the response
				 .extract().response();
		 //to print response
		 System.out.println(response.asString());
		 //
		 // i have to convert into jsOn, converting response to variable
		 
		 String jsonresponse = response.asString(); 
		 //
		 JsonPath responsebody =new JsonPath(jsonresponse); // basically convert normal string to json path
		 System.out.println(responsebody.get("message"));
		  
	
		 
	}
	@Test ( priority = 1)
	public void login()
	{
		RestAssured.baseURI = baseurl;
		 String requestbody = "{\r\n"
		 		+ "	\"email\": \"Sanjana46507@gmail.com\",\r\n"
		 		+ "	\"password\": \"sanjana@123\"\r\n"
		 		+ "}\r\n"
		 		+ "";
		 
		 //This time i want to know what my response is in my console
		 Response response = given()
				 .header("content-Type","application/json")
				 .body(requestbody)
				 
				 .when()
				 .post("/user/login")
				 
				 .then()
				 .assertThat().statusCode(200).contentType(ContentType.JSON)
				 //to extract the response
				 .extract().response();
		 //to print response
		 System.out.println(response.asString());
		 //
		 // i have to convert into jsOn, converting response to variable
		 
		 String jsonresponse = response.asString(); 
		 //
		 JsonPath responsebody =new JsonPath(jsonresponse); // basically convert normal string to json path
		 System.out.println(responsebody.get("acessToken"));
		 accessToken = responsebody.get("accessToken"); 
		 	 

      }
	
	@Test (priority = 2)
	public void get()
	{
		RestAssured.baseURI = baseurl;
		
		
		 //This time i want to know what my response is in my console
		 Response response = given()
				 .header("content-Type","application/json")
				 .header("Authorization","bearer "+accessToken)
				 //.body(requestbody)
				
				 .when()
				 .get("/user")
				
				 .then()
				 .assertThat().statusCode(200).contentType(ContentType.JSON)
				 //to extract the response
				 .extract().response();
		 //to print response
		 //
		 // i have to convert into jsOn, converting response to variable
		
		 String jsonresponse = response.asString();
		 //
		 JsonPath responsebody =new JsonPath(jsonresponse); // basically convert normal string to json path
		 System.out.println(responsebody.get("users[200]._id"));
		 id = responsebody.get("users[200]._id");
		 	
	} 
	
	@Test (priority = 3)
	public void delete()
	{
		RestAssured.baseURI = baseurl;
		
		
		 //This time i want to know what my response is in my console
		 Response response = given()
				 .header("content-Type","application/json")
				 .header("Authorization","bearer "+accessToken)
				 //.body(requestbody)
				
				 .when()
				 .delete("/user/"+id)
				
				 .then()
				 .assertThat().statusCode(200).contentType(ContentType.JSON)
				 //to extract the response
				 .extract().response();
		 //to print response
		 //
		 // i have to convert into jsOn, converting response to variable
		
		 String jsonresponse = response.asString();
		 //
		 JsonPath responsebody =new JsonPath(jsonresponse); // basically convert normal string to json path
		 System.out.println(responsebody.get("message"));
		 	
	} 
	
	
}


