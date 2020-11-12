package gigaberlin.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    //TODO: for crossBrowser Parametrized Test

    private static final String OS = "os.name";
    private static final String OS_TYPE = "os.arch";
    private static final String CHROME_PATH_WIN = "src\\main\\resources\\chromedrivers\\win\\chromedriver.exe";
    private static final String EDGE_PATH_WIN = "src\\main\\resources\\chromedrivers\\win\\msedgedriver.exe";
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String EDGE_DRIVER = "webdriver.edge.driver";

//    WebDriver driver;

    public static WebDriver WebDriver(Browser type) {
        WebDriver driver = null;
        switch (type) {
            case Edge:
                driver = EdgeDriver();
                break;
//            case Firefox:
//                driver = FirefoxDriver();
//                break;
            case Chrome:
                driver = ChromeDriver();
                break;
        }
        return driver;
    }

    private static ChromeDriver ChromeDriver() {
        if (System.getProperty(OS).contains(OSystem.Windows.getOS())) {
            System.setProperty(CHROME_DRIVER, CHROME_PATH_WIN);
        }
        return new ChromeDriver();
    }

    private static EdgeDriver EdgeDriver() {
        if (System.getProperty(OS).contains("Windows")) {
            System.setProperty(EDGE_DRIVER, EDGE_PATH_WIN);
        }
        return new EdgeDriver();
    }

}
