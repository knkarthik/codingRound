/**
 * This class must be extended by all the POM classes (eg: in codingRound.pom package)
 * If there are any common actions that are to be performed in each POM classes, such as
 * verifying title, verifying the presense of an element etc. those methods should be put
 * in this class.
 */


package codingRound.generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	

	public void verifyElementIsPresent(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("PASS", true);
		} catch (Exception e) {
			Reporter.log("FAIL", true);
			Assert.fail();
		}
	}
}

