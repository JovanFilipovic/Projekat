package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage {

	Select select;

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getFirstNameInput() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastNameInput() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getUserAddressInput() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhoneNumberInput() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCodeInput() {
		return driver.findElement(By.name("user_zip"));
	}

	public WebElement getCountrySelect() {
		return driver.findElement(By.id("user_country_id"));
	}

	public WebElement getStateSelect() {
		return driver.findElement(By.id("user_state_id"));
	}

	public WebElement getCitySelect() {
		return driver.findElement(By.id("user_city"));
	}

	public WebElement getRemovePhotoButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'remove')]"));
	}

	public WebElement getUploadButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'upload uploadFile-Js')]"));
	}

	public WebElement getInputFile() {
		js.executeScript("arguments[0].click()", getUploadButton());
		return driver.findElement(By.xpath("//input[@type='file']"));
	}

	public WebElement getButtonSave() {
		return driver.findElement(By.name("btn_submit"));
	}

	public void uploadProfilePhoto(String path) {
		getInputFile().sendKeys(path);
	}

	public void removeProfilePhoto() {
		js.executeScript("arguments[0].click()", getRemovePhotoButton());
	}

	public void changeBasicInformations(String firstName, String lastName, String address, String phoneNumber,
			String zipCode, String country, String state, String city) throws InterruptedException {

		getFirstNameInput().clear();
		getFirstNameInput().sendKeys(firstName);

		getLastNameInput().clear();
		getLastNameInput().sendKeys(lastName);

		getUserAddressInput().clear();
		getUserAddressInput().sendKeys(address);

		getPhoneNumberInput().clear();
		getPhoneNumberInput().sendKeys(phoneNumber);

		getZipCodeInput().clear();
		getZipCodeInput().sendKeys(zipCode);

		select = new Select(getCountrySelect());
		select.selectByVisibleText(country);
		Thread.sleep(500);

		select = new Select(getStateSelect());
		select.selectByVisibleText(state);
		Thread.sleep(500);

		select = new Select(getCitySelect());
		select.selectByVisibleText(city);
		
		getButtonSave().sendKeys(Keys.ENTER);

	}
}
