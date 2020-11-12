package gigaberlin.pages;

import gigaberlin.util.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class GigaBerlinWikipediaPage extends PageObject {



    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[5]/td/span[1]/span/a/span[3]/span[1]")
    private WebElement coordinates;

    @FindBy(id = "Logistics")
    private WebElement logisticsData;

    @FindBy(id = "Site_concerns")
    private WebElement siteConcerns;


    public GigaBerlinWikipediaPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCoordinates() {
        return coordinates;
    }

    public WebElement getLogisticsData() {
        return logisticsData;
    }

    public WebElement getSiteConcerns() {
        return siteConcerns;
    }

    public GeoCoordinatesPage geoCoordinates() throws Exception {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(coordinates).keyUp(Keys.CONTROL).perform();
        takeScreenShot(driver);
        switchToTab(driver,1,300);
        takeScreenShot(driver);
        return new GeoCoordinatesPage(driver);
    }
}
