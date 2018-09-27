package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.EndPoints;
import Utility.PropertyCollection;
import Utility.StringUtility;


public class CreateAccountPage {
	public static  String URL;
	public CreateAccountPage() {
		PageFactory.initElements(Utility.PropertyCollection.driver, this);
	}
	
	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement EmailAddressTextBox;

	@FindBy(xpath = "//button[@id='SubmitCreate']//span")
	private WebElement CreateAccountBtn;
	
	
	public void CreateAccount() 
	{
		
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)PropertyCollection.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		EmailAddressTextBox.sendKeys(StringUtility.Email());
		CreateAccountBtn.click();
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(PropertyCollection.getCurrentURL(URL), EndPoints.AUTHENTICATION_PAGE_URL);
		
		
	}
	
	public  void  createAnAccount()
	{
		
	}
	

	
}
