package utils;

import gigaberlin.driver.ChromeWebDriver;
import gigaberlin.pages.*;
import gigaberlin.util.PropertiesLoader;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * FunctionalTest
 * Class implements the base test methods and fields.
 */

public class BaseTest {
    public static WebDriver driver;

    public final GooglePage googlePage = new GooglePage(driver);
    public final WikipediaPage wikipediaPage = new WikipediaPage(driver);
    public final GigaBerlinPage gigaBerlinPage = new GigaBerlinPage(driver);
    public final GeoCoordinatesPage geoCoordinatesPage = new GeoCoordinatesPage(driver);
    public final GoogleMapPage googleMapPage = new GoogleMapPage(driver);

    @BeforeClass
    public static void setUp() {
        driver = ChromeWebDriver.getWebDriverInstance();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(PropertiesLoader.loadProperty("url"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
