/**
 * All test scripts (eg: those in codingRound.scripts) should extend this class.
 * This class handles the common actions such as opening application, closing application,
 * taking screenshots of failed tests (not implemented), etc.
 */


package codingRound.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConsts {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void openApp() {
		
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void closeApp(){
		
		driver.close();
	}


}

