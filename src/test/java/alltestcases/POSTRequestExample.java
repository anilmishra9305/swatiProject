package alltestcases;

import java.util.List;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import junit.framework.Assert;
import utility.CommonFunction;
import utility.RestAPIFunction;

public class POSTRequestExample extends TestBase{

	
	@Test
	public void postRequest()
	{
		
		CommonFunction function=new CommonFunction();
		List<String> listparameter=function.getExcelData("test.xlsx", "POST", 0);
		RestAPIFunction api=new RestAPIFunction();
		response=api.postRequest(listparameter.get(0), "/posts");
		
		
		
		System.out.println("Response Code ==> "+response.getStatusCode());
		System.out.println("Title ==> "+response.jsonPath().getString("title"));
		System.out.println("Body ==> "+response.jsonPath().getString("body"));
		Assert.assertEquals(201, response.getStatusCode());
		function.assertEquals("Automation Testing Title", response.jsonPath().getString("title"));
		function.assertEquals("Automation Testing Body", response.jsonPath().getString("body"));
	
		
	}
	
	
	
	
	
}
