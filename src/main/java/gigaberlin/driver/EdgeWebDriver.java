package gigaberlin.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * EdgeWebDriver
 * Class sets the system suitable chromedriver and instantiates a Chrome WebDriver object.
 */
public class EdgeWebDriver {

    private static final String DRIVER_PATH_WIN = "src\\main\\resources\\chromedrivers\\win\\msedgedriver.exe";
    private static final String OS = "os.name";
    private static final String DRIVER = "webdriver.edge.driver";

    /**
     * Static method checks for the system name and architecture type and sets the suitable system edge driver properties.
     *
     * @return new WebDriver object which corresponds local system Edge properties.
     */
    public static WebDriver getWebDriverInstance() {
        if (System.getProperty(OS).contains("Windows")) {
            System.setProperty(DRIVER, DRIVER_PATH_WIN);
        }
        return new EdgeDriver();
    }
}
