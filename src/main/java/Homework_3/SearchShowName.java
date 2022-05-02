package Homework_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

// Предусловие: пользователь залогинился на сайте ororo.tv
// 1. В хедере в поле поиска ввести название сериала

public class SearchShowName {
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
        WebElement webElementSearch1 = driver.findElement(By.cssSelector("li[class='menu-item dropmodule dropmodule-search']"));
        webElementSearch1.click();
        WebElement webElementSearch2 = driver.findElement(By.cssSelector("input[class='search-box-input js-header-search-input']"));
        webElementSearch2.sendKeys("Друзья");
        WebElement webElementFound = driver.findElement(By.cssSelector(".search-results-item:nth-child(1)"));
        webElementFound.click();
        // driver.quit();
    }
}
