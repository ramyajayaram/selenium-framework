package pageobjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.PropertyCollection;
import dataset.SearchDataSet;

public class Search {
	
	public Search() {
		PageFactory.initElements(Utility.PropertyCollection.driver, this);
	}
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	public WebElement SearchBox;
	
	
	
	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement Searchbutton;
	
	
	@FindBy(xpath = "//a[@title='Blouse'][contains(text(),'Blouse')]")
	public WebElement SearchTextBlouse;
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	public WebElement AddToCart;
	
	
	//div[@class='layer_cart_product col-xs-12 col-md-6']//h2
	
	@FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2//text()")
	public WebElement AddToCartSuccessMessage;
	
	//a[@title='Proceed to checkout']//span
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']//span")
	public WebElement ProceedToCheckOutButton;
	
	//p[@class='cart_navigation clearfix']//span[1]
	
	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//span[1]")
	public WebElement ProceedToCheckOutBtn;
	
	public  void SearchItem()
	{
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SearchBox.sendKeys(SearchDataSet.WomensWear);
		Searchbutton.click();
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyCollection.getText(SearchTextBlouse);
		Assert.assertEquals(PropertyCollection.getText(SearchTextBlouse),SearchDataSet.WomensWear );
		
		
	}
	
	
	public void  addToCartAndOrderItem()
	{
		PropertyCollection.scrollVerticallyDown();
		SearchTextBlouse.click();
			
		String parentHandle = PropertyCollection.driver.getWindowHandle(); // get the current window handle
		AddToCart.click();// click some link that opens a new window

		for (String winHandle :PropertyCollection.driver.getWindowHandles()) {
			PropertyCollection.driver .switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyCollection.scrollVerticallyDown();
		ProceedToCheckOutButton.click();
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyCollection.driver.close(); // close newly opened window when done with it
		PropertyCollection.driver.switchTo().window(parentHandle);
		PropertyCollection.driver.close(); 
		ProceedToCheckOutBtn.click();
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

	
	

}
