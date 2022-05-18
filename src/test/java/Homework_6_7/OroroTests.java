package Homework_6_7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.junit.jupiter.api.DisplayName;
import java.io.File;

@Story("Работа с сайтом ororo.tv")
public class OroroTests extends AbstractTest {

    @Test
    @DisplayName("Изменение уровня английского")
    @Description("Изменить уровень языка на intermediate, проверить корректность изменения, вернуть обратно уровень beginner")
    @Link("https://docs.google.com/spreadsheets/d/1h0fbaQCH-0nVD85U1dWNIX9wKw4e__rAx7wwRMVEYdo/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void changeUserSettings() throws InterruptedException {
        new MainMenu(getDriver())
                .userMenu();
        new MainMenu(getDriver())
                .userMenuSettings();
        new PersonalSettings(getDriver())
                .intermediate();

        String s = new PersonalSettings(getDriver())
                .curLevel();
        Assertions.assertEquals("Intermediate", s);
        File file = MyUtils.makeScreenshot(getDriver(),"afterChangeToIntermediate_screenshot" + System.currentTimeMillis() + ".png");
        Thread.sleep(3000);
        new PersonalSettings(getDriver())
                .low();
    }

    @Test
    @DisplayName("Поиск сериала по названию")
    @Description("Вбить в поиск название сериала Друзья, найти его в результатах выдачи")
    @Link("https://docs.google.com/spreadsheets/d/1h0fbaQCH-0nVD85U1dWNIX9wKw4e__rAx7wwRMVEYdo/edit?usp=sharing")
    @Severity(SeverityLevel.CRITICAL)
    void searchShowName()  {
        new MainMenu(getDriver())
                .searchField();
        new MainMenu(getDriver())
                .search("Друзья");
        new SearchElement(getDriver())
                .elementFound();
        Assertions.assertTrue(getDriver().findElement(By.xpath("//div[@class='show-content__title']")).getText().contains("Friends"), "Сериал Друзья не найден");
    }

    @Test
    @DisplayName("Сортировка списка сериалов")
    @Description("Отсортировать список сериалов по рейтингу")
    @Link("https://docs.google.com/spreadsheets/d/1h0fbaQCH-0nVD85U1dWNIX9wKw4e__rAx7wwRMVEYdo/edit?usp=sharing")
    @Severity(SeverityLevel.MINOR)
    void sortShows() {
        String s = new SortElement(getDriver())
                .sorting();
        Assertions.assertEquals("Рейтингу", s);
    }

    @Test
    @DisplayName("Изменение языка сайта")
    @Description("Сменить язык сайта на английский, затем вернуть русский")
    @Severity(SeverityLevel.CRITICAL)
    void changeLang() {
        String s = new MainMenu(getDriver())
                .changeLangEng();
        Assertions.assertEquals("En", s);
        new MainMenu(getDriver())
                .changeLangRu();
    }

    @Test
    @DisplayName("Наличие баннера на странице")
    @Description("Проверка наличия баннера на странице после авторизации пользователя")
    @Severity(SeverityLevel.NORMAL)
    void banner() {
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='active-banner']")).size(), 1);
    }

    @Test
    @DisplayName("Пункты меню пользователя")
    @Description("Проверить, что меню пользователя содержит все необходимые пункты")
    @Severity(SeverityLevel.CRITICAL)
    void userMenu() {
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-subscription']")).size(), 1);
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-dictionary']")).size(), 1);
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-gift']")).size(), 1);
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-referral']")).size(), 1);
    }



}
