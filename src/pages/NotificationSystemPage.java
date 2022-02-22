package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Da se proba i u Basic da bude Wait

	public NotificationSystemPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getMessageElement() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}

	public String getMessageText(WebElement element) {
		return element.findElement(By.xpath("div")).getText();
	}

	public void waitMessageToDisaper() {
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}
}
