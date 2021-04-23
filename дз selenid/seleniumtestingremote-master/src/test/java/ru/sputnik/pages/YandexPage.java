package ru.sputnik.pages;

import org.openqa.selenium.By;
import ru.sputnik.tests.WebDriverSettings;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;


public class YandexPage extends WebDriverSettings {
        public String YANDEXURL = "https://www.yandex.ru/";
        public String SEARCHREQUEST = "Погода в Пензе";
        public String YANDEX = "Яндекс";

        public SelenideElement searchFieild = $(byCssSelector("input#text"));
        public SelenideElement weatherResult = $(By.linkText(SEARCHREQUEST));

}
