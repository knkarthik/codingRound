/**
 * This is the POM class for Sign in page. Use this class to store and update elements
 * Methods of this class are called from test classes present in codingROund.scripts package
 * as needed.
 */


package codingRound.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import codingRound.generic.BasePage;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Your trips")
	private WebElement yourTriplLink;

	@FindBy(id = "SignIn")
	private WebElement signIn;

	@FindBy(id = "modal_window")
	private WebElement signInForm;

	@FindBy(xpath = "//*[@id='signInButton']")
	private WebElement signInButton;

    @FindBy(id = "errors1")
    private WebElement errorText;


	public void clickYourTrips(){
		yourTriplLink.click();
	}

	public void clickSignIn(){
		signIn.click();
	}
	
	public void clickSignInButton(){

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modal_window']")));
		signInButton.click();
	}


	public String getSignInErrors(){
		return errorText.getText();
	}

}
