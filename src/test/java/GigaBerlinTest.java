import gigaberlin.pages.*;
import org.junit.Test;
import utils.BaseTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * GigaBerlinTest
 * Class for tests. Execute test scenario.
 */
public class GigaBerlinTest extends BaseTest {

    @Test
    public void test_searchWikipediaChrome() throws Exception {
        googlePage.cookiesAcceptance(driver);
        googlePage.searchWikipediaPage();

        assertTrue(wikipediaPage.getWelcomeWiki().isDisplayed());
        assertEquals("Wikipedia", wikipediaPage.getWelcomeWiki().getText());

        wikipediaPage.searchGigaBerlinPage();

        assertTrue(gigaBerlinPage.getCoordinates().isEnabled());
        assertEquals("Logistics", gigaBerlinPage.getLogisticsData().getText());
        assertEquals("Site concerns", gigaBerlinPage.getSiteConcerns().getText());

        gigaBerlinPage.geoCoordinates();
        geoCoordinatesPage.googleMapLocation();

        assertEquals("52.400000, 13.800000", googleMapPage.getSearchBoxInput().getText());
    }

}
