package utility;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAPIFunction extends TestBase {
	
	
	
	
	
	public Response postRequest(String requestbody,String parameter)
	{
		
		
		try {
			CommonFunction function=new CommonFunction();
			RestAssured.baseURI=function.readEnvFile("URI");
			response=RestAssured.given().header("Content-type","application/json")
			.and().body(requestbody).when().post(parameter).then()
			.extract().response();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
		
	}
	
	
	public String getanyJsonPropertyValue(String propertyName)
	{
		String result=response.jsonPath().getString(propertyName);
		return result;
		
	}
	
	
	public int getStatusCode()
	{
		
		int statuscode=response.getStatusCode();
		return statuscode;
		
	}
	
	public Response putRequest(String requestbody,String methodParam)
	{
		
		 response=RestAssured.given().header("Content-type","application/json")
				.and().body(requestbody).when().put(methodParam)
				.then().extract().response();
		 
		 return response;
	}
	
	
	
	
	public Response patchRequest(String body,String param)
	{
		
		
		response=RestAssured.given().header("Content-type","application/json")
		.and().body(body).when().patch(param).then().extract().response();
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
