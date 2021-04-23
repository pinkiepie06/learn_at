package ru.sputnik.tests;

import org.testng.annotations.Test;
import ru.sputnik.pages.YandexPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class NavigationTest extends YandexPage {
        @Test
    public void navigationTest(){
        YandexPage yandexPage = new YandexPage();


        open(YANDEXURL);
        $("title").shouldHave(attribute("text", yandexPage.YANDEX));
        yandexPage.searchFieild.val(yandexPage.SEARCHREQUEST).pressEnter();

        yandexPage.weatherResult.shouldBe();
        yandexPage.weatherResult.click();
        $(byText(yandexPage.SEARCHREQUEST)).shouldBe();
        }
}
