package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesDemo 
{
	//@Test
	void testCookies()
	{
		given()
		
		.when()
		  .get("https://www.google.com/")
		
		.then()
		   .log().all();
	}
	
	@Test
	public void getcookiesInfo()
	{
	Response res= given()
		         
			      .when()
		             .get("https://www.google.com/");
	
	//String cookies_value=res.getCookie("AEC");
	//System.out.println("cookie value=======>"+cookies_value);
	
	Map<String,String>cookies_All_value=res.getCookies();
	//System.out.println("All key=======>"+cookies_All_value.keySet());
	
	for(String k:cookies_All_value.keySet())
	{
		String cookie_value=res.getCookie(k);
		System.out.println(k+"--->"+cookie_value);
	}

	
		
	}

}
