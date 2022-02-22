package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getClearAllButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'cart-head')]/a[2]"));
	}
	
	public void clearAll() {
		getClearAllButton().click();
	}
	
}
