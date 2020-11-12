package gigaberlin.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ChromeWebDriver
 * Class sets the system suitable chromedriver and instantiates a Chrome WebDriver object.
 */
public class ChromeWebDriver {
    private static final String DRIVER_PATH_WIN = "src\\main\\resources\\chromedrivers\\win\\chromedriver.exe";
    private static final String OS = "os.name";
    private static final String DRIVER = "webdriver.chrome.driver";

    /**
     * Static method checks for the system name and architecture type and sets the suitable system chromedriver properties.
     *
     * @return new WebDriver object which corresponds local system Chrome properties.
     */
    public static WebDriver getWebDriverInstance() {
        if (System.getProperty(OS).contains("Windows")) {
            System.setProperty(DRIVER, DRIVER_PATH_WIN);
        }
            return new ChromeDriver();
        }


}
