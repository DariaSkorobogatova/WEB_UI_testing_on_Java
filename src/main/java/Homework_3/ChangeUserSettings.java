package Homework_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

// Предусловие: пользователь залогинился на сайте ororo.tv
// 1. В хедере в выпадающем списке рядом с аватаркой пользователя выбрать настройки
// 2. Выбрать персональные настройки слева в меню либо прокрутить страницу до них
// 3. В поле Уровень владения языком вводим уровень и нажимаем сохранить

public class ChangeUserSettings {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://ororo.tv/ru");
        WebElement webElementLogIn = driver.findElement(By.xpath("//a[@class='menu-link droplink login']/span"));
        webElementLogIn.click();
        WebElement webElementEmail = driver.findElement(By.id("user_email"));
        WebElement webElementPassword = driver.findElement(By.id("user_password"));
        webElementEmail.sendKeys("indiansummer29@mail.ru");
        webElementPassword.sendKeys("summer29");
        WebElement webElementOk = driver.findElement(By.xpath("//input[@class='ui blue submit button']"));
        webElementOk.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElementUserMenu = driver.findElement(By.cssSelector(".icon-arrow:nth-child(3)"));
        webElementUserMenu.click();
        WebElement webElementUserMenuSettings = driver.findElement(By.cssSelector("li:nth-child(6) > a > span"));
        webElementUserMenuSettings.click();
        WebElement webElementUserPersonalSettings = driver.findElement(By.xpath("//button[@data-anchor='#s-personal']"));
        webElementUserPersonalSettings.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElementUserLevel = driver.findElement(By.cssSelector("div[class='select select-white select-border select-language-level js-select simple']"));
        webElementUserLevel.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElementUserChooseLevel = driver.findElement(By.cssSelector(".select-item:nth-child(2) > .text"));
        webElementUserChooseLevel.click();
        WebElement webElementSave = driver.findElement(By.cssSelector(".btn:nth-child(5) > span"));
        webElementSave.click();
        // driver.quit();
    }
}
