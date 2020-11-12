package gigaberlin.pages;

import gigaberlin.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeoCoordinatesPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div/div[2]/div[2]/p/a[2]")
    private WebElement googleMapLink;

    public GeoCoordinatesPage(WebDriver driver) {
        super(driver);
    }

    public void googleMapLocation() throws Exception {
        clickOnWebElement(googleMapLink);
        takeScreenShot(driver);
    }
}
