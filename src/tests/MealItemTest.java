package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest {

	@Test(priority = 0, enabled = true)
	public void addMealToCartTest() {

		driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		locPP.closeJumpDialog();
		mealP.addMealToCart("42");
		Assert.assertEquals(notiSP.getMessageText().contains("The Following Errors Occurred:"), true,
				"[Error], message shown unexpected");
		Assert.assertEquals(notiSP.getMessageText().contains("Please Select Location"), true,
				"[Error], message shown unexpected");
		notiSP.waitMessageToDisaper();
		locPP.getLocationHeader().click();
		locPP.setLocation("City Center - Albany");
		driver.navigate().refresh();
		mealP.addMealToCart("43");
		Assert.assertEquals(notiSP.getMessageText().contains("Meal Added To Cart"), true,
				"[Error], message shown unexpected");
	}

	@Test(priority = 1, enabled = true)
	public void addMealToFavoritesTest() throws InterruptedException {

		driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		locPP.closeJumpDialog();
		mealP.addToFavorites();
		Assert.assertEquals(notiSP.getMessageText().contains("Please login first!"), true,
				"[Error], Unexpected message");
		driver.navigate().to(baseUrl + "guest-user/login-form");
		loginP.login(email, password);
		Thread.sleep(2000);
		driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mealP.addToFavorites();
		Assert.assertEquals(notiSP.getMessageText().contains("Product has been added to your favorites.."), true,
				"[Error], Unexptected message");

	}

	@Test(priority = 2, enabled = true)
	public void clearCartTest() throws IOException {

		driver.get(baseUrl + "meals");
		locPP.setLocation("City Center - Albany");

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Meals");

		for (int i = 1; i < 6; i++) {
			String mealUrl = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(mealUrl);
			mealP.addMealToCart("3");
			softAssert.assertEquals(notiSP.getMessageText().contains("Meal Added To Cart"), true,
					"[Error], unexpected message");
		}
		cartSumP.clearAll();
		softAssert.assertEquals(notiSP.getMessageText().contains("All meals removed from Cart successfully"), true,
				"[Error], unexpected message");

		softAssert.assertAll();
	}
}
