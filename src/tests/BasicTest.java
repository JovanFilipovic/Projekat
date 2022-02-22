package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class BasicTest {

	WebDriver driver;
	Actions action;
	LocationPopupPage locPP;
	LoginPage loginP;
	ProfilePage profileP;
	NotificationSystemPage notiSP;
	JavascriptExecutor js;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");

		driver = new ChromeDriver();
		action = new Actions(driver);
		locPP = new LocationPopupPage(driver);
		loginP = new LoginPage(driver);
		profileP = new ProfilePage(driver);
		notiSP = new NotificationSystemPage(driver);
		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("http://demo.yo-meals.com/");

	}

	@Test(enabled = true)
	public void demoTest() throws Exception {

		   locPP.closeJumpDialog();
		   locPP.openLocationHeader();
		   locPP.setLocation("Helderberg - Albany");
		
		   loginP.login("", "");
		   
		   driver.navigate().to("http://demo.yo-meals.com/member/profile");
		   
		   
		   profileP.uploadProfilePhoto("C:\\Users\\anast\\Desktop\\LikX.png");
		   
		   System.out.println(notiSP.getMessageText(notiSP.getMessageElement()));
		 
		   Thread.sleep(3000);
		   
		   profileP.removeProfilePhoto();
		   
		   notiSP.waitMessageToDisaper();
		   driver.navigate().refresh();
	}


	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(15000);
		driver.quit();
	}

}
