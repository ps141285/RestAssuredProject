package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo 
{
	    @Test
		void testHeader()
		{
			given()
			
			.when()
			  .get("https://www.google.com/")
			
			.then()
			   .log().headers()
			   .log().cookies();
		}
	    //@Test
	    void getHeaderInfo()
	    {
	   Response res=given()
	    	
	    	        .when()
	    	          .get("https://www.google.com/");
	  //String header_value= res.getHeader("Date");
	  //System.out.println("header value====>"+header_value);
	    Headers header_All_value=res.headers();	
	    for(Header h:header_All_value)
	    {
	    	System.out.println(h.getName()+"       "+h.getValue());
	    }
	    	
	    }

}
