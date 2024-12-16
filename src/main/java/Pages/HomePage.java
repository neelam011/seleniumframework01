package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By welcomeMessage=By.xpath("//h4[@class='welcomeMessage']");

	public String verifyMessage() {
	String message=driver.findElement(welcomeMessage).getText();
	System.out.println("testing ......"+message);
	return message;
	}
	
	
}
