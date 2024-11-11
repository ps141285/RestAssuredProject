package Day3;
import static io.restassured.RestAssured.*;  // To set up the base URI and configure Rest Assured
import static io.restassured.matcher.RestAssuredMatchers.*;  // Optional: For additional matchers
import static org.hamcrest.Matchers.*;  // For assertions on response data

import org.testng.annotations.Test;


public class TestQueryAndPathParameter
{
	@Test
	void testQueryAndPathParameter()
	{
		 given()                 //actual API (https://gorest.co.in/public/v2/posts/166559)
		 .pathParam("mypath", "posts")
		 .queryParam("id", 166559)
		   
		 .when()
		  .get("https://gorest.co.in/public/v2/{mypath}")
		
		.then()
		   .statusCode(200)
		   .log().all();
		
		
	}

}
