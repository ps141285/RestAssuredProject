package Day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLParsingResponse 
{
	@Test
	void testXMLResponse()
	{
		//Approch 1
		
		/*given()
		
		.when()
		   .get("http://samplerestapi.com/api/petslover/")
		
		.then()
		  .statusCode(200)
		  .header("Cache-Control",equalTo("no-cache"))
		  .log().all();
		*/
		//Approch2

	Response res=given()
		
		         .when()
		            .get("http://samplerestapi.com/api/petslover/");
	
	  Assert.assertEquals(res.getStatusCode(),200);
	  Assert.assertEquals(res.header("Pragma"),"no-cache");
	  String Page_no=res.xmlPath().get("PetsLoverInformationResponse.page").toString();
	  Assert.assertEquals(Page_no,"1");	
	}
	@Test
	void testXMLResponseBody()
	{
		Response res=given()
				
		         .when()
		            .get("http://samplerestapi.com/api/petslover/");
		
		XmlPath xmlobj=new XmlPath(res.asString());
		List<String>petlovers=xmlobj.getList("PetsLoverInformationResponse.travelers.PetsloverInformation");
		//System.out.println(petlovers.size());
		Assert.assertEquals(petlovers.size(), 10);
		List<String>petlovers_name=xmlobj.getList("PetsLoverInformationResponse.travelers.PetsloverInformation.name");
		
		boolean status=false;
		for(String name:petlovers_name)
		{
			System.out.println(name);
			/*if(name.equals("Adam"))
			{
				status=true;
			}*/
		}
		//Assert.assertEquals(status, true);//every time names changed in xml test is failed
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
