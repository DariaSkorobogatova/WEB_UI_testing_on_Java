package Homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchElement extends AbstractElement {

    @FindBy(css = ".search-results-item:nth-child(1)")
    private WebElement webElementFound;

    public SearchElement(WebDriver driver){
        super(driver);
    }

    public void elementFound() {
        this.webElementFound.click();
    }
}
