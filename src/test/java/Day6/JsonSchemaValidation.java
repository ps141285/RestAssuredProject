package Day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation
{
	@Test
	void TestJsonSchema()
	{
		given()
		
		.when()
		   .get("https://gorest.co.in/public/v2/users")
		.then()
		   .statusCode(200)
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("UserSchema.json"));
		  
	}

}
