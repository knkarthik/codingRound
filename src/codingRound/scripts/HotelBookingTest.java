/**
 * This is the test class for hotel booking test
 * This class calls BaseTest which run the @BeforeMethod and opens the app, calls methods
 * of FlightPage and execute the necessary steps after which @AfterMethod is run
 */

package codingRound.scripts;

import org.testng.annotations.Test;
import codingRound.generic.BaseTest;
import codingRound.pom.SearchForHotelsPage;;

public class HotelBookingTest extends BaseTest{
	
	@Test
	public void testHotelBooking(){
		SearchForHotelsPage hotels = new SearchForHotelsPage(driver);
		hotels.clickHotel();
		// Ideally the variables should be taken from file/database instead of hard-cording
		hotels.enterLocation("Indiranagar, Bangalore");
		hotels.clickSearch();
	}

}
