package utils;

import gigaberlin.driver.ChromeWebDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * FunctionalTest
 * Class implements the base test methods and fields.
 */

public class FunctionalTest {
    protected static WebDriver driver;

    /**
     * creates ScreenShots if test failed.
     */
    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            takeScreenShot(description.getDisplayName());
        }
    };


    @BeforeClass
    public static void setUp() {
        driver = ChromeWebDriver.getWebDriverInstance();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    @After
    public void cleanUp() {
    }

    @AfterClass
    public static void tearDown() {
        	driver.close();
    }

    /**
     * method for screenshots when test is failed
     * @param methodName name of the method which was failed
     */
    private void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/screenshots/"
                    + LocalDateTime.now().toString().substring(0, 19).replace(":", "-")
                    + "_" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
