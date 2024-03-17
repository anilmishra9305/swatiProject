package alltestcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import testdatareader.ReadxlsFile;
import utility.CommonFunction;
import utility.RestAPIFunction;

public class PatchRequestExample extends TestBase {

	
	
	@Test
	public void patchRequest()
	{
		
		CommonFunction function=new CommonFunction();
		ReadxlsFile xlsFile=new ReadxlsFile();
		RestAPIFunction restapifunction=new RestAPIFunction();
		RestAssured.baseURI=function.readEnvFile("URI");
		Map<Integer, List<Object>> map=xlsFile.readxlsFile("test.xlsx", "PATCH");
		String body=map.get(1).get(0).toString();
		
		response=restapifunction.patchRequest(body, "/posts/1");
		
		function.assertEquals(200, restapifunction.getStatusCode());
		function.assertEquals("Automation Updated Title", restapifunction.getanyJsonPropertyValue("title"));
		
		
		
		
		
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
