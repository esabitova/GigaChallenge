package gigaberlin.pages;

import gigaberlin.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaPage extends PageObject {

    @FindBy(id = "searchInput")
    private WebElement searchBox;
    @FindBy(id="searchButton")
    private WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"js-link-box-en\"]/strong")
    private WebElement englishLanguage;
    @FindBy(xpath = "//*[@id=\"mp-welcome\"]/a")
    private WebElement welcomeWiki;

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWelcomeWiki() {
        return welcomeWiki;
    }

    public GigaBerlinPage searchGigaBerlinPage() throws Exception {
//        clickOnWebElement(englishLanguage);
        sendTextToWebElement(searchBox, "Giga Berlin");
        takeScreenShot(driver);
        clickOnWebElement(searchBtn);
        takeScreenShot(driver);

        return new GigaBerlinPage(driver);
    }
}
