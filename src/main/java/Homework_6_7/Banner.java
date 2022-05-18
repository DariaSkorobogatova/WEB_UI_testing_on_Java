package Homework_6_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Banner extends AbstractElement {

    @FindBy(xpath = "//*[@class='active-banner']")
    private WebElement banner;

    public Banner(WebDriver driver){
        super(driver);
    }

    public WebElement getBanner() {
        return banner;
    }
}
