package pageobjects;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.PropertyCollection;


public class LoginPage {
	public LoginPage() {
		PageFactory.initElements(Utility.PropertyCollection.driver, this);
	}

	String LoginTitle = "Login - My Store";
	String Logintitle;

	String Email;

	String Password;

	@FindBy(xpath = "//a[@class ='login']")
	private WebElement signinMenu;

	@FindBy(id = "email_create")
	private WebElement EmailAddressTextBox;

	@FindBy(xpath = "//button[@id='SubmitCreate']//span")
	private WebElement CreateAccountBtn;

	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement SignOutMenu;

	@FindBy(xpath = "//li[@class='open']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Logout')]")
	private WebElement LogOutSubmenu;

	public void Login() {
		final String driverPath = "C:\\Users\\Ramya\\eclipse-workspace\\ApplicationTest\\Drivers\\";

		PropertyCollection.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		signinMenu.click();
		Assert.assertEquals(PropertyCollection.getPageTitle(Logintitle), LoginTitle);
		System.out.println("Login successfully....");

	}

	public void logout() {
		SignOutMenu.click();
		Assert.assertEquals(PropertyCollection.getPageTitle(Logintitle), LoginTitle);
		System.out.println("Logged out Successfully-----");
	}

	public void loginFailed() {
       
	}

	public void forgotPassword() {

	}

}
