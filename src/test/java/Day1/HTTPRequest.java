package Day1;
/*
  givin()
       content type,set cookies,add auth,add param,set header info etc 
  when() 
       get post put delete
  then() 
       validate status code,extract response,extract header cookies and response body....  
  */
import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;  // To set up the base URI and configure Rest Assured
import static io.restassured.matcher.RestAssuredMatchers.*;  // Optional: For additional matchers
import static org.hamcrest.Matchers.*;  // For assertions on response data

import java.util.HashMap;




public class HTTPRequest 
{
	int id;
	
	//@Test(priority=1)
	void getUser()
	{
		given()
		
	    .when()
		    .get("http://localhost:3000/students/")
		.then()
		     .statusCode(200)
		     .log().all();
		   
	}
	@Test(priority=2)
	void createUser()
	{
		HashMap data=new HashMap();
		data.put("id", "12");
		data.put("name", "manoj");
		data.put("location", "Gwalior");
		data.put("phone", "8839488807");
		
		String courseArr[]= {"sansex","bitcoin"};
		data.put("courses", courseArr);
		
		id=given()
		 .contentType("application/json")
		 .body(data)
		
		.when()
		 .post("http://localhost:3000/students")
		 .jsonPath().getInt("id");
		//.then()
		 //.statusCode(201)
		 //.log().all();
		 
	}
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name", "meenu");
		data.put("location", "seondha");
		
		given()
		 .contentType("application/json")
		 .body(data)
		
		.when()
		 .put("http://localhost:3000/students/"+id)
		
		.then()   
		  .statusCode(200)
		  .log().all();
	}
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
		 .delete("http://localhost:3000/students/"+id)
		
		.then()   
		  .statusCode(200)
		  .log().all();
	}

}
