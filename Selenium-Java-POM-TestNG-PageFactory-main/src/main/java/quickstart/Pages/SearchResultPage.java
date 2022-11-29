package quickstart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.TimeOuts;

public class SearchResultPage {

	WebDriver driver;



	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
	}

	public  boolean istextDisplayed(String elementName) {
	
		String searchResult="//a[contains(.,'"+elementName+"')]";
		WebDriverWait wait= new WebDriverWait(driver, TimeOuts.DEFAULT_TIMEOUT);
		WebElement ele= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResult)));
		return ele.isDisplayed();
	}
	

}
