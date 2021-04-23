package ru.mail.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static logs.ru.mail.Log.logger;
import static ru.mail.WebDriverSettings.wait;

public class Logic {

    public static void сompare(String stringToCompare, WebElement elementToCompare) {
        logger.info("Compare started " + elementToCompare);
        String textElement = elementToCompare.getText();
        Assert.assertTrue(textElement.equals(stringToCompare));
        logger.info(textElement + " совпадает с " + stringToCompare);

    }
}
