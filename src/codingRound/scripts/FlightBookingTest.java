/**
 * This is the test class for flight booking test
 * This class calls BaseTest which run the @BeforeMethod and opens the app, calls methods
 * of FlightPage and execute the necessary steps after which @AfterMethod is run
 */

package codingRound.scripts;

import org.testng.annotations.Test;
import codingRound.generic.BaseTest;
import codingRound.pom.FlightPage;

public class FlightBookingTest extends BaseTest{

	@Test
	public void testFlightBooking(){
		FlightPage fp = new FlightPage(driver);
		fp.clickOneWay();
		
		// Ideally the variables should be taken from excel sheets/ databases instead of hard-coding
		fp.enterFrom("Bangalore");
		fp.enterTo("Delhi");
		/*
		 * Date is set to 22/10/2017 for now. To make sure this code works every time,
		 * it is better to se the date to today's date as:
		 *     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 *     dateFormat.format(new Date());
		 * 
		 * and then pass this as argument to setDate (change corresponding class accordingly)     
		 *     
		 */
		fp.setDate();
		fp.clickSearchButton();
		fp.isElementPresent();
	}
}
