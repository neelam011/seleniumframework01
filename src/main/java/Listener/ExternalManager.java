package Listener;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;

public class ExternalManager {

	static ExtentReports report;

	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
		report=createInstance();
		return report;
		}else
		{
			return report;
		}
	}
	

	public static ExtentReports createInstance()
	{
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/automation"+Utility.getCurrentDateTime()+".html");
		spark.config().setReportName("automation report");
		spark.config().setDocumentTitle("sprint 1");
		spark.config().setTheme(Theme.DARK);
		ExtentReports extent = new ExtentReports();
		//ExtentKlovReporter klov = new ExtentKlovReporter("myNewProject").initWithDefaultSettings();
		extent.attachReporter(spark);
		return extent;
	}
	
	
	
}
