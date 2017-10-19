/**
 * This is the test class for sign in test
 * This class calls BaseTest which run the @BeforeMethod and opens the app, calls methods
 * of FlightPage and execute the necessary steps after which @AfterMethod is run
 */

package codingRound.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import codingRound.generic.BaseTest;
import codingRound.pom.SignInPage;

public class SignInTest extends BaseTest{
	
	@Test
	public void testSignInPage(){
		
		SignInPage signPage = new SignInPage(driver);
		signPage.clickYourTrips();
		signPage.clickSignIn();
		signPage.clickSignInButton();
		Assert.assertTrue(signPage.getSignInErrors().contains("There were errors in your submission"));
	}

}
