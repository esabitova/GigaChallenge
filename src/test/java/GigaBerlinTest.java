import gigaberlin.pages.*;
import gigaberlin.util.PropertiesLoader;
import org.junit.Before;
import org.junit.Test;
import utils.BaseTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * BasicTest
 * Class for tests.
 */

public class GigaBerlinTest extends BaseTest {
    GooglePage googlePage=new GooglePage(driver);
    WikipediaPage wikipediaPage = new WikipediaPage(driver);
    GigaBerlinPage gigaBerlinPage = new GigaBerlinPage(driver);
    GeoCoordinatesPage geoCoordinatesPage = new GeoCoordinatesPage(driver);
    GoogleMapPage googleMapPage = new GoogleMapPage(driver);

    @Before
    public void init() {
        driver.manage().window().maximize();
    }

    @Test
    public void test_searchWikipediaChrome() throws Exception {
        driver.get(PropertiesLoader.loadProperty("url"));
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
