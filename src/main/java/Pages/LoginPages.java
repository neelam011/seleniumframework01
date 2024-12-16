package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {
	WebDriver driver;
	public LoginPages(WebDriver driver)
	{
		this.driver=driver;
	}
	By user=By.xpath("//*[@id='email1']");
	By password=By.xpath("//*[@id='password1']");
	By signin=By.xpath("//*[text()='Sign in']");
	
	
	public HomePage loginToApp(String uname,String pass)
	{
		driver.findElement(user).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signin).click();
		HomePage home=new HomePage(driver);
		return home;
	}
}
