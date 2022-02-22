package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getAddToFavoritesButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'favourite')]"));
	}
	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'js-proceedtoAddInCart')]"));
	}
	
	public WebElement getQuantityInput() {
		return driver.findElement(By.name("product_qty"));
	}
	
	public void addMealToCart(String quantity) {
		getQuantityInput().clear();
		getQuantityInput().sendKeys(Keys.BACK_SPACE);
		getQuantityInput().sendKeys(String.valueOf(quantity));
		getAddToCartButton().click();
	}
	
	public void addToFavorites() {
		if(getAddToCartButton().getCssValue("title") != "Favorite")
		getAddToFavoritesButton().click();
	}
}
