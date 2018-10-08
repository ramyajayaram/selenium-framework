package excelLib;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*import pageobjects.ExcelTest;
ExcelTest objExcelData = null;
try {
	objExcelData = new ExcelTest("C:\\Users\\Ramya\\Downloads\\Login.xlsx");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Email = objExcelData.getCellData("Sheet1", "Email", 2);
Password = objExcelData.getCellData("Sheet1", "Password", 2);*/
public class ExcelLibrary {
	
		public FileInputStream fis = null;
		public XSSFWorkbook workbook = null;
		public XSSFSheet sheet = null;
		public XSSFRow row = null;
		public XSSFCell cell = null;

		public ExcelLibrary(String xlFilePath) throws Exception {
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

