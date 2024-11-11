package Day2;
import static io.restassured.RestAssured.*;  // To set up the base URI and configure Rest Assured
import static io.restassured.matcher.RestAssuredMatchers.*;  // Optional: For additional matchers
import static org.hamcrest.Matchers.*;  // For assertions on response data

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
/*
 Different Ways to create POST Req
 1.Post req body creation using HashMap
 2.Post req body creation using Org.json
 3.Post req body creation using POJO class
 4.Post req using creation external json file data 
*/
public class DifferentWaysToCreatePostReq 
{
	//@Test(priority=1)
	void testpostusinghashmap()
	{
		HashMap data=new HashMap();
		data.put("id", "11");
		data.put("name", "manav");
		data.put("location","Delhi");
		data.put("phone", "8839489907");
		
		String courseArr[]= {"c","c++"};
		data.put("courses", courseArr);
		
		    given()
		    .contentType("application/json")	
		    .body(data)
		   
		   .when()
		     .post("http://localhost:3000/students")
		   
		   .then()
		     .statusCode(201)
		     .body("name",equalTo("manav"))
		     .body("location",equalTo("Delhi"))
		     .body("phone",equalTo("8839489907"))
		     .body("courses[0]",equalTo("c"))
		     .body("courses[1]",equalTo("c++"))
		    // .header("Content-Type","application/json; charset=utf-8")
		     
		     .log().all();
		
	}
	//@Test(priority=1)
	void testUsingOrgjson()
	{
		JSONObject data=new JSONObject();
		data.put("id", "11");
		data.put("name", "manav");
		data.put("location","Delhi");
		data.put("phone", "8839489907");
		
		String courseArr[]= {"c","c++"};
		data.put("courses", courseArr);
		
		    given()
		    .contentType("application/json")	
		    .body(data.toString())
		   
		   .when()
		     .post("http://localhost:3000/students")
		   
		   .then()
		     .statusCode(201)
		     .body("name",equalTo("manav"))
		     .body("location",equalTo("Delhi"))
		     .body("phone",equalTo("8839489907"))
		     .body("courses[0]",equalTo("c"))
		     .body("courses[1]",equalTo("c++"))
		    // .header("Content-Type","application/json; charset=utf-8")
		     
		     .log().all();
		
	}
	//@Test(priority=1)
	void testUsingPOJOclass()
	{
		POJOClass data=new POJOClass();
		data.setId("11");
		data.setName("abhishek");
		data.setLocation("lakhnow");
		data.setPhone("9090908787");
		
		String CourseArr[]= {"IT","Law"};
		data.setCourses(CourseArr);
		
		given()
	    .contentType("application/json")	
	    .body(data)
	   
	   .when()
	     .post("http://localhost:3000/students")
	   
	   .then()
	     .statusCode(201)
	     .body("name",equalTo("abhishek"))
	     .body("location",equalTo("lakhnow"))
	     .body("phone",equalTo("9090908787"))
	     .body("courses[0]",equalTo("IT"))
	     .body("courses[1]",equalTo("Law"))
	    // .header("Content-Type","application/json; charset=utf-8")
	     
	     .log().all();
	
	}	
	@Test(priority=1)
	void testUsingExternalJson() throws FileNotFoundException
	{
		File f=new File(".\\Body.json");
		FileReader fr=new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		JSONObject jd=new JSONObject(jt);
		
		given()
	    .contentType("application/json")	
	    .body(jd.toString())
	   
	   .when()
	     .post("http://localhost:3000/students")
	   
	   .then()
	     .statusCode(201)
	     .body("name",equalTo("Aarav"))
	     .body("location",equalTo("pune"))
	     .body("phone",equalTo("77658745355"))
	     .body("courses[0]",equalTo("Java"))
	     .body("courses[1]",equalTo("Salesforce"))
	    // .header("Content-Type","application/json; charset=utf-8")
	     
	     .log().all();
		
	}
	
	@Test(priority=2)
	void deleteTest()
	{ 
		given()
		
		.when()
		   .delete("http://localhost:3000/students/11")
		
		.then()
		.log().all();
		
	}
	

}
