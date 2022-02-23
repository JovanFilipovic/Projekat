package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasicPage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getSearchResult(){
		return driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}
	
	public List<String> getAllElementsNames(){
		List<String> listaImena = null;
		for (int i = 0; i < getSearchResult().size(); i++) {
			listaImena.add(getSearchResult().get(i).getText());
		}
		return listaImena;
	}
	
	public int searchResultNumber() {
		return getSearchResult().size();
	}
}
