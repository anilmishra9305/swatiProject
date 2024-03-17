package alltestcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.testng.annotations.Test;

import utility.CommonFunction;

public class BasicAuthorization {
	
	
	@Test
	public void basicAuthentication()
	{
		
		try {
			
			String username="john";
			String password="pass";
			
			URL weburl=new URL("https://dummy.restapiexample.com/api/v1/employees");
			
			HttpURLConnection con=(HttpURLConnection) weburl.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Autorization","Basic"+Base64.getEncoder().encodeToString
					((username+":"+password).getBytes()));
			
			CommonFunction function=new CommonFunction();
			function.assertEquals(200, con.getResponseCode());
			System.out.println("Response "+con.getResponseCode());
			System.out.println(con.getContent().toString());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	

}
