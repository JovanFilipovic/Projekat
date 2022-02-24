package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait; 
	
	public BasicPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
}
