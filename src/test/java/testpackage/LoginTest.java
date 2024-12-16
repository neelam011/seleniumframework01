package testpackage;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import Pages.HomePage;
import Pages.LoginPages;
import base.BaseClass;
import dataprovider.ExcelReader;

@Test
public class LoginTest extends BaseClass{
	
	@Test(dataProvider="newdata",dataProviderClass=ExcelReader.class, groups= {"smoke","regrssion"})
	public void login(String uname, String pass)
	{	
		LoginPages login=new LoginPages(driver);
		HomePage homepage=login.loginToApp(uname, pass);
		Assert.assertTrue(homepage.verifyMessage().contains("Welcome"),"Message is displayed");
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
	}
}
