package ru.sputnik.tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverSettings {
    public static String CHROMEDRIVERLOCATION = "chromedriver.exe";
    public static WebDriver driver;

    @BeforeClass
    public void setup(){
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver" ,CHROMEDRIVERLOCATION);
        Configuration.startMaximized = true;
    }

}
