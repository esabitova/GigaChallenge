package gigaberlin.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.apache.commons.lang3.StringUtils.substringAfter;

/**
 * PageObject
 * Class implements the base methods and fields.
 */
public class PageObject {
    protected WebDriver driver;

    private static final String ERROR_START = "\n\nElement not found in: ";
    private static final String ERROR_MIDDLE = " within: ";
    private static final String ERROR_END = " seconds!\n\n";

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * sets the MAXIMUM WAIT time for our conditional waits
     */
    public static int WAIT_TIMEOUT() {
        return 5;
    }

    public void sendTextToWebElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            waitForElementToBeVisible(driver, WAIT_TIMEOUT(), element);
            element.clear();
            element.sendKeys(text);
        }
    }

    /**
     * accepted cookies, but for cross-browser tests doesn't work because index of the frame is depends on browser.
     * Could be used with BasiTest class.
     */
    public void cookiesAcceptance(WebDriver webDriver){
        webDriver.switchTo().frame(0);
        webDriver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();
    }

    /**
     * cuts the WebElement designation into only the xpath
     *
     * @param element gets the xpath of the used WebElement
     * @return only the xpath, not the whole WebElement designation
     */
    private static String cutXpathString(WebElement element) {
        return substringAfter(element.toString(), "->");
    }

    /**
     * conditional explicit wait for Element to be displayed
     *
     * @param seconds MAXIMUM amount of time to wait for condition to be true
     * @param element the element to wait for, it needs to be .isDisplayed() == true
     */
    public static void waitForElementToBeVisible(WebDriver driver, int seconds, WebElement element) {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, seconds)
                .ignoring(StaleElementReferenceException.class);
        wait.withMessage(ERROR_START + element + ERROR_MIDDLE + seconds + ERROR_END);
        wait.until((ExpectedCondition<Boolean>) webDriver -> element != null && element.isDisplayed());
    }

    public void clickOnWebElement(WebElement element) {
        try {
            element.click();
            System.out.println("LOGGING: clicked on element: " + cutXpathString(element));
        } catch (Exception e) {
            System.out.println("LOGGING: Waiting for " + cutXpathString(element) + " to be visible!");
            waitForElementToBeVisible(driver, WAIT_TIMEOUT(), element);
            element.click();
        }
    }


    public static void switchToTab(WebDriver driver, int tabNumber, int sleepTimer){
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        sleep(sleepTimer);
        driver.switchTo().window(tabs2.get(tabNumber));
            }

    /**
     * constant Thread.sleep method, that will ALWAYS wait for millis TIME
     *
     * @param millis the amount of milliseconds it will wait
     */
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * creates ScreenShots if step passed. Could be implements on every step of tests in the needed methods.
     */
    public static void takeScreenShot(WebDriver webdriver) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File("src/screenshots/"
                + LocalDateTime.now().toString().substring(0, 19).replace(":", "-")
                + "_"  + ".png"));
    }
}
