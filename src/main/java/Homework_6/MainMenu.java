package Homework_6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractElement {

    @FindBy(xpath = "//a[@class='site-logo']")
    private WebElement siteLogo;

    @FindBy(css = ".icon-arrow:nth-child(3)")
    private WebElement webElementUserMenu;

    @FindBy(css = "li:nth-child(6) > a > span")
    private WebElement webElementUserMenuSettings;

    @FindBy(css = "li[class='menu-item dropmodule dropmodule-search']")
    private WebElement webElementSearch1;

    @FindBy(css = "input[class='search-box-input js-header-search-input']")
    private WebElement webElementSearch2;

    @FindBy(xpath = "//li[@class='menu-item dropmodule dropmodule-language']")
    private WebElement language;

    @FindBy(xpath = "//a[contains(text(), 'English')]")
    private WebElement engLang;

    @FindBy(xpath = "//a[@class='menu-link droplink js-header-menu-droptrigger']/span")
    private WebElement currentLang;

    @FindBy(xpath = "//a[contains(text(), 'Russian')]")
    private WebElement ruLang;

    public MainMenu(WebDriver driver){
        super(driver);
    }

    public void searchField() {
        this.webElementSearch1.click();
    }

    public MainMenu search(String item){
        this.webElementSearch2.sendKeys(item);
        return this;
    }

    public void logo() {
        this.siteLogo.click();
    }

    public void userMenu() {
        this.webElementUserMenu.click();
    }

    public void userMenuSettings() {
        this.webElementUserMenuSettings.click();
    }

    public String changeLangEng() {
        this.language.click();
        this.engLang.click();
        return currentLang.getText();
    }

    public void changeLangRu() {
        this.language.click();
        this.ruLang.click();

    }


}
