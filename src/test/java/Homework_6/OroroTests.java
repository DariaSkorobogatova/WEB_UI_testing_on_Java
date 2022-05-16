package Homework_6;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class OroroTests extends AbstractTest {

    @Test
    //поменять уровень языка на intermediate, проверить корректность изменения, вернуть обратно уровень beginner
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
        Thread.sleep(3000);
        new PersonalSettings(getDriver())
                .low();
    }

    @Test
    // искать сериал Друзья, убедиться, что он есть в выдаче
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
    // отсортировать сериалы по рейтингу
    void sortShows() {
        String s = new SortElement(getDriver())
                .sorting();
        Assertions.assertEquals("Рейтингу", s);
    }

    @Test
        // сменить язык на английский, потом вернуть русский
    void changeLang() {
        String s = new MainMenu(getDriver())
                .changeLangEng();
        Assertions.assertEquals("En", s);
        new MainMenu(getDriver())
                .changeLangRu();
    }

    @Test
        // наличие баннера
    void banner() {
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='active-banner']")).size(), 1);
    }

    @Test
        // проверить, что меню пользователя содержит все необходимые элементы
    void userMenu() {
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-subscription']")).size(), 1);
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-dictionary']")).size(), 1);
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-gift']")).size(), 1);
        Assertions.assertEquals(getDriver().findElements(By.xpath("//*[@class='icon-referral']")).size(), 1);
    }



}
