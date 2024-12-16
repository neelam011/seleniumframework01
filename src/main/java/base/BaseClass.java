package base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import dataprovider.ConfigReader;
import factoryfile.BrowserActivity;

public class BaseClass 
{
	public WebDriver driver;
	@BeforeClass
	public void setup() throws IOException
	{
		System.out.print("browser open");
		driver=BrowserActivity.BrowserActivityOpen(ConfigReader.getValue("browser"),ConfigReader.getValue("url"));	
		imutablewait();
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.print("browser closed");
		driver.quit();
	}
	
	
	public void imutablewait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
}
