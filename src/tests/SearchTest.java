package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class SearchTest extends BasicTest {
	
	@Test (priority = 0, enabled = true)
	public void searchResultsTest() throws IOException {
		
		driver.get(baseUrl  + "meals");
		locPP.setLocation("City Center - Albany");
		
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Meal Search Results");
		
		for (int i = 1; i < 6; i++) {
			
			String location = sheet.getRow(i).getCell(0).getStringCellValue();
			String url = sheet.getRow(i).getCell(1).getStringCellValue();
			int numOfResults = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
	
			driver.navigate().to(url);
			locPP.openLocationHeader();
			locPP.setLocation(location);
			
						
			for (int j = 0; j < searchResP.searchResultNumber(); j++) {
				String resultName = sheet.getRow(i).getCell(j + 3).getStringCellValue(); // null bude, mora try ili adresiranje exceptionom
				softAssert.assertEquals(searchResP.getAllElementsNames().get(j), resultName, "[Error], result name unexpected" );
			}
			
			softAssert.assertEquals(searchResP.searchResultNumber(), numOfResults, "[Error] number of results unexpected");
		}
		softAssert.assertAll();
	}
}
