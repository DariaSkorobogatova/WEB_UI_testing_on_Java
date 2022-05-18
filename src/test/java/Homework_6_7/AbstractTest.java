package Homework_6_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    @DisplayName("Авторизация пользователя")
    static void init() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://ororo.tv/ru"),
                "Страница не доступна");
        new LogInElement(getDriver())
                .loginForm();
        Thread.sleep(3000);
        new LogInElement(getDriver())
                .logIn("indiansummer29@mail.ru","summer29");
        Thread.sleep(10000);
        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@class='name']/span")).getText().equals("Indiansummer29"));
    }

    @BeforeEach
    @DisplayName("Переход на главную страницу")
    void mainPage(){
        new MainMenu(getDriver())
                .logo();
    }

    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){
            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }

//    @AfterAll
//    public static void close(){
//        driver.quit();
//    }

    public static WebDriver getDriver() {
        return driver;
    }
}