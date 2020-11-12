package gigaberlin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import gigaberlin.util.PageObject;

/**
 * GooglePage
 * Class implements the methods and fields of the Google Search page.
 */
public class GooglePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]")
    private WebElement searchBtn;

    @FindBy(xpath = "//span[contains(text(),'Giga Berlin - Wikipedia')]")
    private WebElement resultLink;


    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public GigaBerlinWikipediaPage searchWikiGigaBerlinPage() throws Exception {
        sendTextToWebElement(searchBox, "Giga Berlin");
        takeScreenShot(driver);
        clickOnWebElement(searchBtn);
        takeScreenShot(driver);
        clickOnWebElement(resultLink);
        takeScreenShot(driver);

        return new GigaBerlinWikipediaPage(driver);
    }



}
