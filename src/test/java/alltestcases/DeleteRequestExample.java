package alltestcases;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import utility.CommonFunction;
import utility.RestAPIFunction;

public class DeleteRequestExample extends TestBase{
	
	
	@Test
	public void deleteRequest()
	{
		
		
		CommonFunction function=new CommonFunction();
		RestAssured.baseURI=function.readEnvFile("URI");
		response= RestAssured.given().header("Content-type","application/json")
		 .when().delete("/posts/1").then().extract().response();
		 
		System.out.println(" Response "+response.getStatusCode());
		function.assertEquals(200, response.statusCode());
		
		
	}
	
	

}
