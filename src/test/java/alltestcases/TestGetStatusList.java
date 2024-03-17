package alltestcases;

import java.net.URI;

import org.apache.http.client.utils.URIBuilder;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestGetStatusList {
	
	
	
	private final String CONSUMER_KEY="kOGDexaSGsJzllQxEwGQAY7su";
	
	private final String CONSUMER_SCERET="XwfYlclCulFWEvCqczumUTUJYoqGaxKFp6sx7zYQLV8Y4UFILJ";
	private final String ACCESS_TOKEN="917811410138152960-itjOvVAYwPNqtzifjus9xEGDMZFofGh";
	private final String ACCESS_SCERET="xEFi7ADsxdmHi7tXhT8Bqxl3wOisJZJmFyEubpUcmsgjp";
	
	private final String UPLOAD_URL="https://api.twitter.com/1.1/statuses/update.json";
	
	@Test
	
	public void testgetStatus()
	{
		
		
		
		try {
			
			
			URI builder=new URIBuilder()
					.setScheme("https")
					.setHost("api.twitter.com")
			.setPath("/1.1/statuses/update.json")
			.addParameter("status", "This post is for rest api")
			.build();
			
			String response=RestAssured.given().auth().
					oauth(CONSUMER_KEY,CONSUMER_SCERET, ACCESS_TOKEN, ACCESS_SCERET)
                           .when().post(builder).thenReturn().asString();
			System.out.println("Response "+response);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
