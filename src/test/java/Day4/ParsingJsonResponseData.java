package Day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData 
{
	//@Test(priority=1)
	void testJsonResponse()
	{
		//Approch 1
		given()
		  .contentType(ContentType.JSON)
		
		.when()
		  .get("http://localhost:3000/store")
		   
		
		.then()
		  .statusCode(200)
		  .header("Content-Type","application/json")
		  .body("books[2].title",equalTo("Learning Python"))
		  .log().all();
		
		//Approch 2
		
     Response res=given()
		              .contentType(ContentType.JSON)
		
		            .when()
		               .get("http://localhost:3000/store");
      
       int status_code=res.statusCode();
       String header_detail= res.contentType();       
       String title =res.jsonPath().get("books[2].title").toString();
       Assert.assertEquals(status_code,200);
       Assert.assertEquals(header_detail,"application/json");
       Assert.assertEquals(title,"Learning Python");
      
	}
	//@Test(priority=2)
	void testJsonResponseBodydata()
	{
		
       Response res=given()
		              .contentType(ContentType.JSON)
		
		            .when()
		               .get("http://localhost:3000/store");
       
     JSONObject jo=new JSONObject(res.asString());
     
     for(int i=0;i<jo.getJSONArray("books").length();i++)
     {
    	 String id=jo.getJSONArray("books").getJSONObject(i).get("bookId").toString();
    	 int book_id=Integer.parseInt(id);
    	 System.out.println("BookID====>"+book_id);
         String title=jo.getJSONArray("books").getJSONObject(i).get("title").toString();
    	 System.out.println("Title=====>"+title);
    	 String Author=jo.getJSONArray("books").getJSONObject(i).get("author").toString();
    	 System.out.println("Author=====>"+Author);
    	 String Ratings=jo.getJSONArray("books").getJSONObject(i).get("ratings").toString();
    	 System.out.println("Ratings=====>"+Ratings);
    	 String ISBN=jo.getJSONArray("books").getJSONObject(i).get("isbn").toString();
    	 System.out.println("ISBN=====>"+ISBN);
    	 System.out.println("");
     }
     
   }
	@Test
	void SearchingDataInJSONobj()
	{
		 Response res=given()
	              .contentType(ContentType.JSON)
	
	            .when()
	               .get("http://localhost:3000/store");
  
        JSONObject jo=new JSONObject(res.asString());
		
        boolean status=false;
		for(int i=0;i<jo.getJSONArray("books").length();i++)
		{
		  String book_title=jo.getJSONArray("books").getJSONObject(i).get("title").toString();
		  if(book_title.equals("Introduction to Java"))
		  {
			  status=true;
			  break;
		  }
		
		}
		Assert.assertTrue(true);
		
		
		double total_price=0;
		for(int i=0;i<jo.getJSONArray("books").length();i++)
		{
			
			String TotalofPrice=jo.getJSONArray("books").getJSONObject(i).get("price").toString();
			total_price=total_price+Double.parseDouble(TotalofPrice);
			
		}
		System.out.println("total price of all books======>"+total_price);
		Assert.assertEquals(total_price, 1366.5);
	}
	
}


