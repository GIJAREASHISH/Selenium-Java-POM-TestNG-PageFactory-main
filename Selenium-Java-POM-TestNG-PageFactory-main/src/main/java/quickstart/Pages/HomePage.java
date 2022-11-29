package quickstart.Pages;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.TimeOuts;
import functionLibrary.DateUtil;

public class HomePage  {

	WebDriver driver;


    @FindBy(xpath="//input[@id='fromPlaceName']")
    WebElement leavingFrom;
	
    @FindBy(xpath="//input[@id='toPlaceName']")
    WebElement goingTo;

    @FindBy(xpath="//input[@id='txtJourneyDate']")
    WebElement dateofDep;
    
    @FindBy(xpath="//input[@id='txtReturnJourneyDate']")
    WebElement dateofReturn;
    
 
    @FindBy(xpath="//*[text()[contains(.,'Search for Bus')]]")
    WebElement searchForBus;
    
    
    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody")
    WebElement dateWidgetFrom;
    
    @FindBy(xpath="//*[@id=\"corover-close-btn\"]")
    WebElement close;
    

   
    
  
    
 

	/**
	 * Constructor of the Page class to set the driver.
	 * It is also used to initialize all the elements.
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void fillJourneyDetails(String levingFromValue,String goingToValue) {
		
		leavingFrom.sendKeys(levingFromValue);		
		 Actions act = new Actions(driver);
		 act.pause(2000).perform();
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		 act.sendKeys(Keys.ENTER).perform();
		 act.pause(2000).perform();
		 
		 goingTo.sendKeys(goingToValue);
		
		
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		 act.sendKeys(Keys.ENTER).perform();
		 
	
		 dateofDep.click();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//This is from date picker table
	     
	        //This are the columns of the from date picker table
	        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
	        DateUtil.clickGivenDay(columns, DateUtil.getCurrentDay());

	        dateofReturn.click();
	        List<WebElement> columns1 = dateWidgetFrom.findElements(By.tagName("td"));
	        DateUtil.clickGivenDay(columns1, DateUtil.getCurrentDay());
	        close.click();
	        searchForBus.click();
	}
	
	  public static String getCurrentDay() {
	        //Create a Calendar Object
	        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	        //Get Current Day as a number
	        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	        System.out.println("Today Int: " + todayInt + "\n");

	        //Integer to String Conversion
	        String todayStr = Integer.toString(todayInt);
	        System.out.println("Today Str: " + todayStr + "\n");

	        return todayStr;
	    }
	    //Get The Current Day plus days. You can change this method based on your needs.
	    public static String getCurrentDayPlus(int days) {
	        LocalDate currentDate = LocalDate.now();

	        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
	        return Integer.toString(dayOfWeekPlus);
	    }

	    //Click to given day
	    public static void clickGivenDay(List<WebElement> elementList, String day) {

	        elementList.stream()
	            .filter(element -> element.getText().contains(day))
	            .findFirst()
	            .ifPresent(WebElement::click);

	    }
	    

}
