package alltestcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import junit.framework.Assert;
import testdatareader.ReadxlsFile;
import utility.CommonFunction;

public class GETRequestExample extends TestBase{
	
	
	@Test
	public void getRequest()
	{
		
		logger.debug("GET Request Example");
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		response=RestAssured.given()
		.contentType(ContentType.JSON)
        .when().get("/posts")
        .then().extract().response();
		logger.info("Response code ==> "+response.getStatusCode()+"");
		System.out.println("Response code ==> "+response.getStatusCode()+"");
		
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println("*********************************************");
		System.out.println(response.jsonPath().getString("title"));
		System.out.println(response.jsonPath().getString("body"));
		System.out.println(response.jsonPath().getString("id"));
		System.out.println(response.jsonPath().getString("userId"));
		System.out.println("*********************************************");
		
		
		ReadxlsFile xls=new ReadxlsFile();
		Map<Integer, List<Object>> map=xls.readxlsFile("test.xlsx", "GET");
		System.out.println("******************************");
		List<String> title=new ArrayList<String>();
		for(Map.Entry<Integer, List<Object>> map1:map.entrySet())
		{
			
			System.out.println(map1.getKey()+" "+map1.getValue());
			title.add(map1.getValue().get(0).toString());

			
		}
		
		CommonFunction function=new CommonFunction();
		for(int i=1;i<title.size();i++)
		{
			
			function.assertEquals(title.get(i), response.jsonPath().getString("title["+i+"]"));
		//Assert.assertEquals(title.get(i), response.jsonPath().getString("title["+i+"]"));
        System.out.println(title.get(i)+"  ==> "+ response.jsonPath().getString("title["+i+"]"));
		}
		
		

		
		
	}
	
	

}
