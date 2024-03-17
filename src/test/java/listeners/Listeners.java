package listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	

	
	@Override
	  public void onTestSuccess(ITestResult tr) {
		
		
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, "Test cases PASSED with Name "+tr.getName());
	   
		
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  test=extent.createTest(tr.getName());
		  test.log(Status.FAIL, "Test Case is Failed with Name "+tr.getName());
	   
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  
		  test=extent.createTest(tr.getName());
		  test.log(Status.SKIP, "Test case is Skipped with Name "+tr.getName());
	   
	  }

	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
	 
		  
	  }


	  @Override
	  public void onStart(ITestContext testContext) {
		  
		  long name=System.currentTimeMillis();
		  
		  String path=System.getProperty("user.dir")+"\\Reports\\Automation"+name+".html";
		  reporter=new ExtentHtmlReporter(path);
		  
		  reporter.config().setDocumentTitle("Automation Report");
		  reporter.config().setReportName("REST API REPORT");
		  reporter.config().setTheme(Theme.DARK);
		  extent=new ExtentReports();
		  extent.attachReporter(reporter);
		  
		  extent.setSystemInfo("Project Name", "Banking Domain");
		  extent.setSystemInfo("Host Name", "QA Env");
		  extent.setSystemInfo("user", System.getProperty("user.name"));
		  extent.setSystemInfo("OS Name", System.getProperty("os.name"));
		  
		  
	  }

	  @Override
	  public void onFinish(ITestContext testContext) {
		  
		  extent.flush();
	  }
}
