package Homework_5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class OroroTests extends AbstractTest{

    @Test
    //поменять уровень языка на intermediate, проверить корректность изменения, вернуть обратно уровень beginner
    void changeUserSettings() throws InterruptedException {
        WebElement webElementUserMenu = getDriver().findElement(By.cssSelector(".icon-arrow:nth-child(3)"));
        webElementUserMenu.click();
        WebElement webElementUserMenuSettings = getDriver().findElement(By.cssSelector("li:nth-child(6) > a > span"));
        webElementUserMenuSettings.click();

        Actions intermediate = new Actions(getDriver());
        intermediate.click(getDriver().findElement(By.xpath("//button[@data-anchor='#s-personal']")))
                .pause(3000)
                .click(getDriver().findElement(By.cssSelector("div[class='select select-white select-border select-language-level js-select simple']")))
                .pause(3000)
                .click(getDriver().findElement(By.cssSelector("div[class='level middle']")))
                .pause(3000)
                .click(getDriver().findElement(By.cssSelector(".btn:nth-child(5) > span")))
                .build()
                .perform();

        String s = getDriver().findElement(By.xpath("//div[@class='js-title']/div[@class='text']")).getText();
        Assertions.assertEquals("Intermediate", s);

        Thread.sleep(3000);
        Actions beginner = new Actions(getDriver());
        beginner.click(getDriver().findElement(By.xpath("//button[@data-anchor='#s-personal']")))
                .pause(3000)
                .click(getDriver().findElement(By.cssSelector("div[class='select select-white select-border select-language-level js-select simple']")))
                .pause(3000)
                .click(getDriver().findElement(By.cssSelector("div[class='level low']")))
                .pause(3000)
                .click(getDriver().findElement(By.cssSelector(".btn:nth-child(5) > span")))
                .build()
                .perform();
        Thread.sleep(3000);
    }

    @Test
    // искать сериал Друзья, убедиться, что он есть в выдаче
    void searchShowName()  {
//        Actions search = new Actions(getDriver());
//        search.click(getDriver().findElement(By.cssSelector("li[class='menu-item dropmodule dropmodule-search']")))
//                .sendKeys(getDriver().findElement(By.cssSelector("input[class='search-box-input js-header-search-input']")),"Друзья")
//                .pause(2000);
//        String searchRes = getDriver().getWindowHandle();
//        getDriver().switchTo().window(searchRes);
//        Actions choose = new Actions(getDriver());
//        choose.click(getDriver().findElement(By.xpath("//a[@class='search-results-item active']")))
//                .pause(2000);
        WebElement webElementSearch1 = getDriver().findElement(By.cssSelector("li[class='menu-item dropmodule dropmodule-search']"));
        webElementSearch1.click();
        WebElement webElementSearch2 = getDriver().findElement(By.cssSelector("input[class='search-box-input js-header-search-input']"));
        webElementSearch2.sendKeys("Друзья");
        WebElement webElementFound = getDriver().findElement(By.cssSelector(".search-results-item:nth-child(1)"));
        webElementFound.click();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//div[@class='show-content__title']")).getText().contains("Friends"), "Сериал Друзья не найден");

    }
    @Test
    // отсортировать сериалы по рейтингу
    void sortShows() {
        WebElement webElementSort = getDriver().findElement(By.xpath("//div[@class='sorters']//span[@class='multiselect__single']"));
        webElementSort.click();
        WebElement webElementSortParam = getDriver().findElement(By.cssSelector(".multiselect--active .multiselect__option--highlight"));
        webElementSortParam.click();

        String s = getDriver().findElement(By.xpath("//div[@class='sorters']//span[@class='multiselect__single']")).getText();
        Assertions.assertEquals("Рейтингу", s);
    }

    @Test
        // сменить язык на английский, потом вернуть русский
    void changeLang() {
        WebElement language = getDriver().findElement(By.xpath("//li[@class='menu-item dropmodule dropmodule-language']"));
        language.click();
        WebElement engLang = getDriver().findElement(By.xpath("//a[contains(text(), 'English')]"));
        engLang.click();
//        Actions engLang = new Actions(getDriver());
//        engLang.click(getDriver().findElement(By.xpath("//a[contains(text(), 'English')]")));


        String s = getDriver().findElement(By.xpath("//a[@class='menu-link droplink js-header-menu-droptrigger']/span")).getText();
        Assertions.assertEquals("En", s);

        WebElement languageBack = getDriver().findElement(By.xpath("//li[@class='menu-item dropmodule dropmodule-language']"));
        languageBack.click();
//        Actions languageBack = new Actions(getDriver());
//        languageBack.click(getDriver().findElement(By.xpath("//li[@class='menu-item dropmodule dropmodule-language']")))
//                .pause(2000);
        WebElement ruLang = getDriver().findElement(By.xpath("//a[contains(text(), 'Russian')]"));
        ruLang.click();
//        Actions ruLang = new Actions(getDriver());
//        ruLang.click(getDriver().findElement(By.xpath("//a[contains(text(), 'Russian')]")));

    }

    @Test
        // наличие баннера
    void copyright() {
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
