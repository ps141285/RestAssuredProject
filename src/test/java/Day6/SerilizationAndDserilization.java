package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationAndDserilization 
{
	@Test
	void ConvertPOJOtoJson() throws JsonProcessingException
	{
		StudentPOJO stupojo=new StudentPOJO(); //Serilization part
		stupojo.setId("1");
		stupojo.setName("Manoj");
		stupojo.setLocation("India");
		stupojo.setPhone("8877665544");
		String CourseArr[]= {"physics","maths"};
		stupojo.setCourses(CourseArr);
		
		
		ObjectMapper objmap=new ObjectMapper();
		String Data=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
        System.out.println(Data);
        
      }
	@Test
	void ConvertJsonToPOJO() throws JsonProcessingException
	{
			String jsondata="{\r\n"
					+ "  \"id\" : \"1\",\r\n"
					+ "  \"name\" : \"Manoj\",\r\n"
					+ "  \"location\" : \"India\",\r\n"
					+ "  \"courses\" : [ \"physics\", \"maths\" ],\r\n"
					+ "  \"phone\" : \"8877665544\"\r\n"
					+ "}";
		ObjectMapper objmap=new ObjectMapper();
		StudentPOJO stupojo=objmap.readValue(jsondata,StudentPOJO.class);
		System.out.println("ID======>"+stupojo.getId());
		System.out.println("Name=====>"+stupojo.getName());
		System.out.println("Location====>"+stupojo.getLocation());
		System.out.println("phone======>"+stupojo.getPhone());
		System.out.println("Courses1=====>"+stupojo.getCourses()[0]);
		System.out.println("Courses2=====>"+stupojo.getCourses()[1]);
		
		
				
	
	
		}
	
	 

}
