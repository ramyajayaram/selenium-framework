package pageobjects;

import java.util.concurrent.TimeUnit;

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
	
	@FindBy(xpath = "//input[@id='phone']")
	public WebElement SearchBox;
	
	
	//button[@name='submit_search']
	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement Searchbutton;
	
	
	//a[@title='Blouse'][contains(text(),'Blouse')]
	@FindBy(xpath = "//a[@title='Blouse'][contains(text(),'Blouse')]")
	public WebElement SearchTextBlouse;
	
	
	public  void SearchItem()
	{
		SearchBox.sendKeys(SearchDataSet.Blouse);
		Searchbutton.click();
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyCollection.getText(SearchTextBlouse);
		Assert.assertEquals(PropertyCollection.getText(SearchTextBlouse), "Blouse");
		
		
	}
	
	
	
	
	
	

	
	

}
