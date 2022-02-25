package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getLocationHeader() {
		return driver.findElement(By.xpath("//*[contains (@class, 'location-selector')]"));
	}

	public WebElement getCloseElement() {
		return driver.findElement(By.xpath("//*[@id='location-popup']/div/div/div/div/a"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.name("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void openLocationHeader() {
		this.getLocationHeader().click();
	}

	public void closeJumpDialog() {
		this.getCloseElement().click();
	}

	public void setLocation(String locationName) {
		this.getKeyword().click();
		String locationInputValue = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value = arguments[1]", getLocationInput(), locationInputValue);
		js.executeScript("arguments[0].click()", getSubmit());
	}

}
