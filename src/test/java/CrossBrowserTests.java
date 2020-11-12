import gigaberlin.driver.Browser;
import gigaberlin.driver.DriverFactory;
import gigaberlin.driver.OSystem;
import gigaberlin.pages.GeoCoordinatesPage;
import gigaberlin.pages.GigaBerlinPage;
import gigaberlin.pages.GoogleMapPage;
import gigaberlin.pages.GooglePage;
import gigaberlin.util.PropertiesLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CrossBrowserTests {
    private static WebDriver driver;
    private Browser _browser;
    private Browser browser;
    private OSystem os;

    public CrossBrowserTests(Browser browser, OSystem os) {
        this.browser = browser;
        this.os = os;
    }

    @Parameterized.Parameters
    public static Collection browsersStrings() {
        return Arrays.asList(new Object[][]
                {
                        {Browser.Chrome, OSystem.Windows},
                        {Browser.Edge, OSystem.Windows}
                });
    }

    @Before
    public void Setup() {
        driver = DriverFactory.WebDriver(browser);
        driver.navigate().to(PropertiesLoader.loadProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }


    GooglePage googlePage = new GooglePage(driver);
    GigaBerlinPage gigaBerlinPage = new GigaBerlinPage(driver);
    GeoCoordinatesPage geoCoordinatesPage=new GeoCoordinatesPage(driver);
    GoogleMapPage googleMapPage= new GoogleMapPage(driver);

    @Test
    public void test_searchWikipediaChrome() throws Exception {
        googlePage.cookiesAcceptance(driver);
        googlePage.searchWikipediaPage();

        assertTrue(gigaBerlinPage.getCoordinates().isEnabled());
        assertEquals("Logistics", gigaBerlinPage.getLogisticsData().getText());
        assertEquals("Site concerns", gigaBerlinPage.getSiteConcerns().getText());

        gigaBerlinPage.geoCoordinates();
        geoCoordinatesPage.googleMapLocation();

        assertEquals("52.400000, 13.800000", googleMapPage.getSearchBoxInput().getText());
    }
}
