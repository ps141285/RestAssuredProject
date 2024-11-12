package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LogDemo
{
	 @Test
		void testHeader()
		{
			given()
			
			.when()
			  .get("http://localhost:3000/students")
			
			.then()
			   //.log().body()
			   //.log().headers();
			   //.log().cookies();
			   .log().all();
			  
		}

}
