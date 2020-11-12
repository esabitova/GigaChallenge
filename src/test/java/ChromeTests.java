import gigaberlin.driver.ChromeWebDriver;
import gigaberlin.pages.GeoCoordinatesPage;
import gigaberlin.pages.GigaBerlinWikipediaPage;
import gigaberlin.pages.GoogleMapPage;
import gigaberlin.pages.GooglePage;
import gigaberlin.util.PropertiesLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FunctionalTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * CromeTests
 * class for tests for ChromeBrowser
 */

public class ChromeTests extends FunctionalTest {
    protected static WebDriver driver;

    GooglePage googlePage=new GooglePage(driver);
    GigaBerlinWikipediaPage gigaBerlinPage = new GigaBerlinWikipediaPage(driver);
    GeoCoordinatesPage geoCoordinatesPage = new GeoCoordinatesPage(driver);
    GoogleMapPage googleMapPage = new GoogleMapPage(driver);

    @BeforeClass
    public static void setUp() {
        driver = ChromeWebDriver.getWebDriverInstance();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Before
    public void init() {
        driver.manage().window().maximize();
    }


    @Test
    public void test_searchWikipediaChrome() throws Exception {
        driver.get(PropertiesLoader.loadProperty("url"));
        cookiesAcceptance(driver);
        googlePage.searchWikiGigaBerlinPage();

        assertTrue(gigaBerlinPage.getCoordinates().isEnabled());
        assertEquals("Logistics", gigaBerlinPage.getLogisticsData().getText());
        assertEquals("Site concerns", gigaBerlinPage.getSiteConcerns().getText());

        gigaBerlinPage.geoCoordinates();
        geoCoordinatesPage.googleMapLocation();

        assertEquals("52.400000, 13.800000", googleMapPage.getSearchBoxInput().getText());
    }

    public void cookiesAcceptance(WebDriver webDriver){
        webDriver.switchTo().frame(0);
        webDriver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();
    }
}
