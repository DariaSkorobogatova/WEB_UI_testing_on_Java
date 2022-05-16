package Homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortElement extends AbstractElement {

    @FindBy(xpath = "//div[@class='sorters']//span[@class='multiselect__single']")
    private WebElement webElementSort;

    @FindBy(css = ".multiselect--active .multiselect__option--highlight")
    private WebElement webElementSortParam;

    @FindBy(xpath = "//div[@class='sorters']//span[@class='multiselect__single']")
    private WebElement rating;



    public SortElement(WebDriver driver){
        super(driver);
    }

    public String sorting() {
        this.webElementSort.click();
        this.webElementSortParam.click();
        return this.rating.getText();

    }
}
