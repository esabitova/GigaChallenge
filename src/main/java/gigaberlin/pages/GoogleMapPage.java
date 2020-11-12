package gigaberlin.pages;

import gigaberlin.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMapPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"pane\"]/div/div[1]/div/div/div[2]/div[1]/div[1]/h2/span")
    private WebElement coordinates;

    public GoogleMapPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchBoxInput() {
        return coordinates;
    }
}
