package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import Utility.PropertyCollection;
import Utility.StringUtility;
import dataset.EndPoints;
import excelLib.ExcelLibrary;
import exception.ValidationException;

public class CreateAccountPage {
	public static String URL;

	public CreateAccountPage() {
		PageFactory.initElements(Utility.PropertyCollection.driver, this);
	}

	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement EmailAddressTextBox;

	@FindBy(xpath = "//button[@id='SubmitCreate']//span")
	private WebElement CreateAccountBtn;

	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement Mr_radioBtn;

	@FindBy(xpath = "//input[@id='id_gender2']")
	private WebElement Mrs_radioBtn;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	private WebElement FirstNameTxtBox;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	private WebElement LastNameTxtBox;
   
	@FindBy(xpath = "//input[@id='company']")
	private WebElement CompanyTxtBox;
	
	
	
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailTxtBox;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement PasswordTxtBox;

	@FindBy(id = "days")
	private WebElement DaysDropDown;

	@FindBy(xpath = "//select[@id='months']")
	private WebElement MonthsDropDown;

	@FindBy(xpath = "//select[@id='years']")
	private WebElement YearDropDown;

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement FirstNameTextBox;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastnameTxtBox;

	@FindBy(xpath = "//input[@id='address1']")
	private WebElement Address1TxtBox;

	@FindBy(xpath = "//input[@id='address2']]")
	private WebElement Address2TxtBox;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement cityTxtBox;

	@FindBy(xpath = "//select[@id='id_state']")
	private WebElement stateDropdown;

	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement PostalCodeTxtBox;

	@FindBy(xpath = "//select[@id='id_country']")
	private WebElement CountryDropdown;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement HomePhoneTxtBox;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	private WebElement MobilePhoneTxtBox;

	@FindBy(xpath = "//button[@id='submitAccount']//span")
	private WebElement RegisterButton;

	public void CreateAccount() {

		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyCollection.scrollVerticallyDown();
		EmailAddressTextBox.sendKeys(StringUtility.Email());
		CreateAccountBtn.click();
		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(PropertyCollection.getCurrentURL(URL), EndPoints.AUTHENTICATION_PAGE_URL);

	}

	public void createAnAccount() throws Exception,ValidationException {
		ExcelLibrary objExcelLibrary = null;
		objExcelLibrary = new ExcelLibrary(
				"C:\\Users\\Ramya\\selenium-Framework\\Ecommerce\\DataSheets\\CreateAccountData.xlsx");
		Mrs_radioBtn.click();
		FirstNameTxtBox.sendKeys(objExcelLibrary.getCellData("Sheet1", "FirstName", 2));
		LastNameTxtBox.sendKeys(objExcelLibrary.getCellData("Sheet1", "Lastname", 2));
		PasswordTxtBox.sendKeys(StringUtility.Password());
		FirstNameTextBox.sendKeys(objExcelLibrary.getCellData("Sheet1", "FirstName", 2));
		lastnameTxtBox.sendKeys(objExcelLibrary.getCellData("Sheet1", "Lastname", 2));
		PasswordTxtBox.sendKeys(StringUtility.Password());
		CompanyTxtBox.sendKeys(objExcelLibrary.getCellData("Sheet1", "Company", 2));
		Address1TxtBox.sendKeys(objExcelLibrary.getCellData("Sheet1", "Address", 2));
		cityTxtBox.sendKeys(objExcelLibrary.getCellData("Sheet1", "City", 2));
		/*Select objSelect =new Select(CountryDropdown);
		objSelect.selectByVisibleText(objExcelLibrary.getCellData("Sheet1", "Country", 1));
		Select objSelectStatedropDown =new Select(stateDropdown);
		objSelectStatedropDown.selectByIndex(2);*/
		PostalCodeTxtBox.sendKeys("00001");
		MobilePhoneTxtBox.sendKeys(StringUtility.PhoneNumber());
		Select objSelectStatedropDown =new Select(stateDropdown);
		objSelectStatedropDown.selectByIndex(2);
		RegisterButton.click();
		System.out.println("New User Craeted successfully....");
		
		
	
		
		

	}

}
