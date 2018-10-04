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

class ExcelTest {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelTest(String xlFilePath) throws Exception {
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public String getCellData(String sheetName, String colName, int rowNum) {
		int col_Num = -1;
		try {

			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}

			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(col_Num);

			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + col_Num + " does not exist  in Excel";
		}
	}
}

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

		ExcelTest objExcelData = null;
		try {
			objExcelData = new ExcelTest("C:\\Users\\Ramya\\Downloads\\Login.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Email = objExcelData.getCellData("Sheet1", "Email", 2);
		Password = objExcelData.getCellData("Sheet1", "Password", 2);
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
