package helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		String s=ts.getScreenshotAs(OutputType.BASE64);
		return s;
	}
	
	public static String getCurrentDateTime()
	{
		Date d=new Date();
		SimpleDateFormat stf=new SimpleDateFormat("HH.mm.ss.dd.MM.yyyy");
		String newdate=stf.format(d);
		return newdate;
	}

	public static WebElement findElement(WebDriver driver,By loactor)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(loactor));
		return element;
	}
	
	public static void clickElement(WebDriver driver,By loactor)
	{
		WebElement element=null;
		try {
		element=findElement(driver,loactor );
		element.click();
		}
		catch(Exception e)
		{
			Actions act=new Actions(driver);
			try {
			act.moveToElement(element).click().build().perform();
			}catch(Exception e1)
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", element);
			}
		}
	}

	
}
