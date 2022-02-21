package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getLoginHeaderButton() {
		driver.navigate().refresh();
		return driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div[2]/div[2]/ul/li[2]/a"));
	}
	
	public WebElement getUsernameInput() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getRememberMeButton() {
		return driver.findElement(By.name("remember_me"));
	}
	
	public void login(String username, String password) {
		getLoginHeaderButton().click();
		
		getUsernameInput().clear();
		getUsernameInput().sendKeys(username);
		getPasswordInput().clear();
		getPasswordInput().sendKeys(password);
		//getRememberMeButton().click();
		getLoginButton().click();
	}
}
