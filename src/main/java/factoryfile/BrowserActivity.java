package factoryfile;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class BrowserActivity {
	static WebDriver driver;
	
	public static WebDriver getInstance()
	{
		return driver;
	}
	public static WebDriver BrowserActivityOpen(String Browser,String url)
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}else if(Browser.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		else 
		{
			System.out.println("no match found");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		return driver;
	}
	
	
}
