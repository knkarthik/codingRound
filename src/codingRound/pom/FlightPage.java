/**
 * This is the POM class for flight booking page. Use this class to store and update elements
 * Methods of this class are called from test classes present in codingROund.scripts package
 * as needed.
 */


package codingRound.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import codingRound.generic.BasePage;

public class FlightPage extends BasePage {

	public FlightPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "OneWay")
    private WebElement oneWayRadio;

    @FindBy(id = "FromTag")
    private WebElement fromTextBox;
    
    @FindBy(id = "ToTag")
    private WebElement toTextBox;
    
    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
    private WebElement departDate;
    
    @FindBy(id = "SearchBtn")
    private WebElement searchButton;
    
    @FindBy(className = "searchSummary")
    private WebElement searchSummary;
    
    public void clickOneWay(){
    	oneWayRadio.click();
    }
    
    public void enterFrom(String from){
    	fromTextBox.clear();
    	fromTextBox.sendKeys(from);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	// select the first option
    	driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li")).get(0).click();
    	
    }
    
    public void enterTo(String to){
    	toTextBox.clear();
    	toTextBox.sendKeys(to);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	// select the first option
    	driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li")).get(0).click();
    }
    
    public void setDate(){
    	// Date set as 22/10/2017 for now
    	departDate.click();
    }
    
    public void clickSearchButton(){
    	searchButton.click();
    	
    }
    
    public void isElementPresent(){
    	verifyElementIsPresent(searchSummary);
    }

}
