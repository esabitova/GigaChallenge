import gigaberlin.pages.GeoCoordinatesPage;
import gigaberlin.pages.GoogleMapPage;
import gigaberlin.pages.GooglePage;
import gigaberlin.pages.GigaBerlinWikipediaPage;
import gigaberlin.util.PropertiesLoader;
import org.junit.Before;
import org.junit.Test;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * BasicTest
 * Class for tests.
 */

public class BasicTest extends FunctionalTest {
    GooglePage googlePage=new GooglePage(driver);
    GigaBerlinWikipediaPage gigaBerlinPage = new GigaBerlinWikipediaPage(driver);
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
        googlePage.searchWikiGigaBerlinPage();

        assertTrue(gigaBerlinPage.getCoordinates().isEnabled());
        assertEquals("Logistics", gigaBerlinPage.getLogisticsData().getText());
        assertEquals("Site concerns", gigaBerlinPage.getSiteConcerns().getText());

        gigaBerlinPage.geoCoordinates();
        geoCoordinatesPage.googleMapLocation();

        assertEquals("52.400000, 13.800000", googleMapPage.getSearchBoxInput().getText());
    }

}
