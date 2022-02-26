package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getUserMenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'after-arrow user-trigger-js')]"));
	}

	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]/ul/li[1]/a"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]/ul/li[2]/a"));
	}

	public void logoutUser() throws InterruptedException {
		getUserMenu().click();
		Thread.sleep(300);
		getLogoutButton().click();
	}
}
