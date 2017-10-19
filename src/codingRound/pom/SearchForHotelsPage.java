/**
 * This is the POM class for Hotels page. Use this class to store and update elements.
 * Methods of this class are called from test classes present in codingROund.scripts package
 * as needed.
 */



package codingRound.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import codingRound.generic.BasePage;

public class SearchForHotelsPage extends BasePage{

	public SearchForHotelsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    public void clickHotel(){
    	hotelLink.click();
    }
    
    public void enterLocation(String location){
    	localityTextBox.sendKeys(location);
    }
    
    public void selectTravellers(String travellers){
    	Select select = new Select(travellerSelection);
    	select.selectByVisibleText(travellers);
    }
    
    public void clickSearch(){
    	searchButton.click();
    }

}
