package alltestcases;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.RestAssured;

public class TestGetAccessToken {
	
	
	
	private final String CONSUMER_KEY = "0aWgpyaiNWqnteNKZtr2Tpin8";
	private final String CONSUMER_SECRET = "AkN1ddNHGJK28CSHM90ki9jZnx6EsUee2b1WZ5cKszgFN2q8cA";
	private final String HEADER ="oauth_consumer_key=0aWgpyaiNWqnteNKZtr2Tpin8,"
			+"oauth_nonce=K7ny27JTpKVsTgdyLdDfmQQWVLERj2zAK5BslRsqyw,"
			+"oauth_signature=feKWJnOmdlf7fc0WeM4YfPeTBL8%3D"
			+ "oauth_signature_method=HMAC-SHA1,"
			+ "oauth_timestamp=1507832673,"
			+ "oauth_version=1.0";
	
	@Test
	public void getAccessToken()
	{
		
		
		try {
			
			
			Map<String, String> headers=new HashMap<>();
			
			headers.put("Authorization", HEADER);
			URI geturi=new URIBuilder()
					.setScheme("https")
					.setHost("api.twitter.com")
					.setPath("oauth/request_token")
			        .build();
			String response=RestAssured.given().when().log().headers().headers(headers)
					        .post(geturi).thenReturn().asString();
			
			System.out.println("Response "+response);
			
			
						
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
			
	
	
	
	
	

}
