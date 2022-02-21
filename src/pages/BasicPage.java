package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasicPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	public BasicPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
}
