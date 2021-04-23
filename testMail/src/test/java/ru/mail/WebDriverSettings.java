package ru.mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverSettings {
    public static WebDriver driver;
    public  static String mainMailUrl = "https://mail.ru/";
    public static WebDriverWait wait;
   public static  Actions actions;
    int timeout = 20;

   public WebDriverSettings()

       {
           WebDriverManager.chromedriver().setup();//подгружаем драйвер хрома через WebDriverManager
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           wait = new WebDriverWait(driver, timeout);
           actions = new Actions(driver);//очистим черновики

       }
   }






