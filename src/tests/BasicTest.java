package tests;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;
import pages.SearchResultPage;

public abstract class BasicTest {

	SoftAssert softAssert;

	DateFormat dateFormat;
	Date date;

	WebDriver driver;
	Actions action;
	LocationPopupPage locPP;
	LoginPage loginP;
	ProfilePage profileP;
	NotificationSystemPage notiSP;
	AuthPage authP;
	MealPage mealP;
	CartSummaryPage cartSumP;
	SearchResultPage searchResP;
	JavascriptExecutor js;

	String baseUrl;
	String email;
	String password;

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");

		dateFormat = new SimpleDateFormat("dd_MM_yyyy, HH_mm_ss");
		date = new Date();

		softAssert = new SoftAssert();

		driver = new ChromeDriver();
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;

		locPP = new LocationPopupPage(driver);
		loginP = new LoginPage(driver);
		profileP = new ProfilePage(driver);
		notiSP = new NotificationSystemPage(driver);
		authP = new AuthPage(driver);
		mealP = new MealPage(driver);
		cartSumP = new CartSummaryPage(driver);
		searchResP = new SearchResultPage(driver);

		baseUrl = "http://demo.yo-meals.com/";
		email = "customer@dummyid.com";
		password = "12345678a";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			String date1 = dateFormat.format(date);
			takeSnapShot(driver, "C:\\projekti\\Projekat\\screenshots\\" + date1 + ".png");
		}

		Thread.sleep(3000);
		driver.quit();
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
