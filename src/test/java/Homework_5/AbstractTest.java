package Homework_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    // авторизация пользователя
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://ororo.tv/ru"),
                "Страница не доступна");
//        driver.get("https://ororo.tv/ru");
        WebElement webElementLogIn = driver.findElement(By.xpath("//a[@class='menu-link droplink login']/span"));
        webElementLogIn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions login = new Actions(getDriver());
        login.sendKeys(getDriver().findElement(By.id("user_email")),"indiansummer29@mail.ru")
                .pause(2000)
                .sendKeys(getDriver().findElement(By.id("user_password")),"summer29")
                .pause(2000)
                .click(getDriver().findElement(By.xpath("//input[@class='ui blue submit button']")))
                .build()
                .perform();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterEach
     // переход на главную страницу
    void mainPage(){
        WebElement siteLogo = driver.findElement(By.xpath("//a[@class='site-logo']"));
        siteLogo.click();
    }

//    @AfterAll
    // разлогинивание пользователя
//    static void close(){
//        WebElement webElementUser = driver.findElement(By.xpath("//p[@class='name']/span"));
//        webElementUser.click();
//        WebElement webElementLogOut = driver.findElement(By.cssSelector(".logout span"));
//        webElementLogOut.click();
//        // driver.quit();
//    }

    public static WebDriver getDriver() {
        return driver;
    }
}