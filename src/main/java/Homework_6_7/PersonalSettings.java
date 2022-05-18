package Homework_6_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PersonalSettings extends AbstractElement {

    @FindBy(xpath = "//button[@data-anchor='#s-personal']")
    private WebElement personal;

    @FindBy(css = "div[class='select select-white select-border select-language-level js-select simple']")
    private WebElement langLevel;

    @FindBy(css = "div[class='level middle']")
    private WebElement middle;

    @FindBy(css = "div[class='level low']")
    private WebElement low;

    @FindBy(css = ".btn:nth-child(5) > span")
    private WebElement submit;

    @FindBy(xpath = "//div[@class='js-title']/div[@class='text']")
    private WebElement currentLevel;

    public PersonalSettings(WebDriver driver) {
        super(driver);
    }

    public String curLevel() {
        return this.currentLevel.getText();
    }

    public void intermediate() {
        Actions login = new Actions(getDriver());
        login
                .click(this.personal)
                .pause(3000)
                .click(this.langLevel)
                .pause(3000)
                .click(middle)
                .pause(3000)
                .click(this.submit)
                .build()
                .perform();
    }
    public void low() {
        Actions login = new Actions(getDriver());
        login
                .click(this.personal)
                .pause(3000)
                .click(this.langLevel)
                .pause(3000)
                .click(low)
                .pause(3000)
                .click(this.submit)
                .build()
                .perform();
    }
}





