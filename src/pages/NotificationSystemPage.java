package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getMessageElement() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

	public String getMessageText() {
		return getMessageElement().findElement(By.xpath("div")).getText();
	}
	
	public void waitMessageToDisaper() {
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}
}
