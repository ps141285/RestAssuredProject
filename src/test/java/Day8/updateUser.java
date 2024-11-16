package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateUser 
{
	@Test
	void testupdateuser(ITestContext context)
	{
	Faker faker=new Faker();
	
	JSONObject data=new JSONObject();
	data.put("name",faker.name().fullName());
	data.put("gender","Male");
	data.put("email",faker.internet().emailAddress());
	data.put("status","active");
	
	String BearerToken="74f515e6a95c11bf0db71e6db6a345eebbafb7c1c9c06e68dd6bc92c49bd6de4";
	int id=(Integer) context.getSuite().getAttribute("user_id");
    given()
		.headers("Authorization","Bearer "+BearerToken)
		.contentType("application/json")
		.pathParam("id",id)
		.body(data.toString())
	
	.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
	.then()
	     .log().all();

      }
}
