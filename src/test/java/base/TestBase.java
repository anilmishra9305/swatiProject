package base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	
	public static RequestSpecification httpRequest;
	
	public static Response response;
	public static Logger logger;
	
	
	@BeforeSuite
	public void logSetup()
	{
		logger=Logger.getLogger("Rest API Log");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
	}
	
	

}
