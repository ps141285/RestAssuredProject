package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser 
{
	@Test
	void testdeleteuser(ITestContext context)
	{
		String BearerToken="74f515e6a95c11bf0db71e6db6a345eebbafb7c1c9c06e68dd6bc92c49bd6de4";
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+BearerToken)
		.contentType("application/json")
		.pathParam("id",id)
		
	
	.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
	.then()
		.statusCode(204)
	     .log().all();
	}

}
