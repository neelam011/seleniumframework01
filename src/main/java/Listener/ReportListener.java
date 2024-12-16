package Listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import factoryfile.BrowserActivity;
import helper.Utility;


public class ReportListener implements ITestListener
{
	
ExtentReports extent = ExternalManager.getInstance();
public ExtentTest extentTest;


	public void onTestStart(ITestResult result) {
		extentTest=extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//System.out.println("onTestStart....  "+result.getMethod().getMethodName()+""+Status.PASS);
		extentTest.pass("test passed succefully");
		
	}

	  public void onTestFailure(ITestResult result) {
		//  System.out.println("onTestStart....  "+result.getMethod().getMethodName()+Status.FAIL);
		  
		  String ss=Utility.captureScreenshot(BrowserActivity.getInstance());
		  extentTest.fail("test failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
	  }

	 
	  public void onTestSkipped(ITestResult result) {
		 // System.out.println("onTestStart....  "+Status.SKIP);
		  extentTest.skip("test skiped"+result.getThrowable().getMessage());
	  }


	  public void onFinish(ITestContext context) {
		extent.flush();
		 
	  }

}
