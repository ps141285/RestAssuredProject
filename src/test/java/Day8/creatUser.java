package Day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class creatUser 
{
	@Test
	void testcraeteUser(ITestContext context)
	{
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","Inactive");
		
		String BearerToken="74f515e6a95c11bf0db71e6db6a345eebbafb7c1c9c06e68dd6bc92c49bd6de4";
		
int id=	given()
			.headers("Authorization","Bearer "+BearerToken)
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
	
	//System.out.println("generated  id==>"+id);

		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id",id);
		
	}

}
