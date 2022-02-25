package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class SearchTest extends BasicTest {

	@Test(priority = 0, enabled = true)
	public void searchResultsTest() throws IOException, InterruptedException {

		driver.get(baseUrl + "meals");
		locPP.setLocation("City Center - Albany");

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Meal Search Results");
		DataFormatter df = new DataFormatter();

		for (int i = 1; i < 7; i++) {

			String location = sheet.getRow(i).getCell(0).getStringCellValue();
			String url = sheet.getRow(i).getCell(1).getStringCellValue();
			String numberOfResults = df.formatCellValue(sheet.getRow(i).getCell(2));

			driver.get(url);
			locPP.openLocationHeader();
			locPP.setLocation(location);
			Thread.sleep(500);

			for (int j = 0; j < searchResP.searchResultNumber(); j++) {
				if (sheet.getRow(i).getCell(j + 3) != null) {
					String resultName = sheet.getRow(i).getCell(j + 3).getStringCellValue();
					softAssert.assertEquals(searchResP.getAllElementsNames().get(j).contains(resultName), true,
							"[Error], result name unexpected");
				}
			}

			softAssert.assertEquals(searchResP.searchResultNumber(), Integer.parseInt(numberOfResults),
					"[Error], number of results unexpected");
		}
		softAssert.assertAll();
	}
}
