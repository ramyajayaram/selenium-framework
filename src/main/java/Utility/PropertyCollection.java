package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class Comprises of all the common variables and functions Used across
 * the application for Testing
 *
 */
public class PropertyCollection {

	private static final Object Element = null;
	public static WebDriver driver;
	public static String strApplicationURL;
	public static String strBrowser;
	public static String strChromeDriverPath;
	public static String strIEDriverPath;
	public static String strExportPath;

	public static String  getPageTitle(String pagetitle )
	{
		 pagetitle=PropertyCollection.driver.getTitle();
		return pagetitle;
	}
	
	
	public  static String getCurrentURL(String URL)
	{
		 URL=PropertyCollection.driver.getCurrentUrl();
		
		return URL;
		
	}
	
	


	public static void ScrollByVisibleElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		
	}
	
	
}
