package alltestcases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import testdatareader.ReadxlsFile;
import utility.CommonFunction;
import utility.RestAPIFunction;

public class PUTRequestExample extends TestBase{
	
	
	@Test
	public void putRequest()
	{
		
	ReadxlsFile xlsfile=new ReadxlsFile();
	Map<Integer, List<Object>> map=xlsfile.readxlsFile("test.xlsx", "PUT");
	
	String requestbody= map.get(1).get(0).toString();
	
	CommonFunction function=new CommonFunction();
	RestAPIFunction apiFunction=new RestAPIFunction();
	RestAssured.baseURI=function.readEnvFile("URI");
	
	
	response=apiFunction.putRequest(requestbody, "/posts/1");
	function.assertEquals("Automation Title",apiFunction.getanyJsonPropertyValue("title"));
	function.assertEquals("Automation Body", apiFunction.getanyJsonPropertyValue("body"));
	function.assertEquals("1", apiFunction.getanyJsonPropertyValue("userId"));
	function.assertEquals("1", apiFunction.getanyJsonPropertyValue("id"));
	function.assertEquals(200, apiFunction.getStatusCode());
	
	}
	
	
	
	
	
	

}
