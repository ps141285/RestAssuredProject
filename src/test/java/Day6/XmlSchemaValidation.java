package Day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XmlSchemaValidation 
{
	@Test
	void TestXmlSchema()
	{
		given()
		
		.when()
		   .get("http://samplerestapi.com/api/petslover/")
		.then()
		   .statusCode(200)
		   .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("petlovers.xsd"));

     }
}
