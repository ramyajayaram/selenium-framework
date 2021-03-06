package TestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.PropertyCollection;
import pageobjects.CreateAccountPage;
import pageobjects.LoginPage;
import pageobjects.Search;

public class SmokeTest {
	static final String DRIVER_PATH = "C:\\Users\\Ramya\\eclipse-workspace\\ApplicationTest\\Drivers\\";
	private static final String String = null;

	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			PropertyCollection.driver = initChromeDriver(appURL);
			break;
		case "firefox":
			PropertyCollection.driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			PropertyCollection.driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
		PropertyCollection.driver = new ChromeDriver();
		PropertyCollection.driver.manage().window().maximize();
		PropertyCollection.driver.get(appURL);
		return PropertyCollection.driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		PropertyCollection.driver.manage().window().maximize();
		PropertyCollection.driver.navigate().to(appURL);
		return PropertyCollection.driver;
	}

	@Parameters({ "browserType", "appURL" })
	@Test(priority = 1)
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
			LoginPage objLogin = new LoginPage();
			objLogin.Login();

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}

	@Test(priority = 2)
	public void createAccount() throws Exception {
		CreateAccountPage objCreateAccountPage = new CreateAccountPage();
		objCreateAccountPage.CreateAccount();
		CreateAccountPage objcreateAnAccount = new CreateAccountPage();
		objcreateAnAccount.createAnAccount();

	}

	@Test(priority = 3)
	public void Search() throws Exception {
		Search objSarch= new Search();
		objSarch.SearchItem();
		objSarch.addToCartAndOrderItem();
		objSarch.AssertPurchasedItem();

	}
}
