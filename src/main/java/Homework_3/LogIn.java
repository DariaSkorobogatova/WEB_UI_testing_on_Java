package Homework_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

// 1. Зайти на сайт https://ororo.tv/ru
// 2. В хедере нажать на кнопку Войти
// 3. Ввести адрес почты и пароль и нажать кнопку Войти
// 4. В хедере нажать имя пользователя
// 5. В выпадающем списке выбрать Выйти

public class LogIn {
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
        WebElement webElementUser = driver.findElement(By.xpath("//p[@class='name']/span"));
        webElementUser.click();
        WebElement webElementLogOut = driver.findElement(By.cssSelector(".logout span"));
        webElementLogOut.click();
        // driver.quit();
    }
}
