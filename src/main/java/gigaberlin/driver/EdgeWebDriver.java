package gigaberlin.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * EdgeWebDriver
 * Class sets the system suitable chromedriver and instantiates a Chrome WebDriver object.
 */
public class EdgeWebDriver {

    private static final String DRIVER_PATH_WIN = "src\\main\\resources\\chromedrivers\\win\\geckodriver.exe";
    private static final String OS = "os.name";
    private static final String DRIVER = "webdriver.gecko.driver";

    /**
     * Static method checks for the system name and architecture type and sets the suitable system edge driver properties.
     *
     * @return new WebDriver object which corresponds local system Edge properties.
     */
    public static WebDriver getWebDriverInstance() {
        if (System.getProperty(OS).contains("Windows")) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            System.setProperty(DRIVER, DRIVER_PATH_WIN);
        }
        return new FirefoxDriver();
    }
}
