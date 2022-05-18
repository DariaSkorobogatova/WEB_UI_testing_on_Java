package Homework_6_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogInElement extends AbstractElement {

    @FindBy(xpath = "//a[@class='menu-link droplink login']/span")
    private WebElement webElementLogIn;

    @FindBy(id = "user_email")
    private WebElement mail;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(xpath = "//input[@class='ui blue submit button']")
    private WebElement submit;

    public LogInElement(WebDriver driver){
        super(driver);
    }

    public void loginForm(){
        this.webElementLogIn.click();
    }

    public void logIn(String mail, String password){
        Actions login = new Actions(getDriver());
        login
                .click(this.mail)
                .sendKeys(mail)
                .pause(2000)
                .click(this.password)
                .sendKeys(password)
                .pause(2000)
                .click(this.submit)
                .build()
                .perform();
    }
}
