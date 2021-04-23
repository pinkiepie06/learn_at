package ru.mail.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import static logs.ru.mail.Log.logger;
import static ru.mail.WebDriverSettings.wait;
import static ru.mail.WebDriverSettings.actions;


public class MailPage {

    public WebDriver driver;


    private String pass = "661112s";
    private String login = "aks1998evgesha";
    public static String subject = "Some Subject";
    public static String To = "aks1998evgesha@gmail.ru";
    public static String Text = "Some text";


    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);//передаем на вход драйвер из WebDriverSettings
        this.driver = driver;
    }

    @FindBy(id = "mailbox:login-input")
    private WebElement loginEnter;

    @FindBy(id = "mailbox:submit-button")
    private WebElement loginButton;

    @FindBy(id = "mailbox:password-input")
    private WebElement passEnter;

    @FindBy(id = "mailbox:submit-button")
    private WebElement passButton;

    @FindBy(className = "compose-button__txt")
    private WebElement createLetterButton;

    @FindBy(xpath = "//*[contains(text(), 'Черновики')]")
    private WebElement draftsButton;

    @FindBy(css = ".layer__submit-button .button2__txt")
    private WebElement clearDraftsContextButton;

    @FindBy(name = "Subject")
    private WebElement subjectEnter;

    @FindBy(className = "container--zU301")
    private WebElement letterToEnter;

    @FindBy(css = "div[role='textbox'] > div:nth-of-type(1)")
    private WebElement letterKeysEnter;

    @FindBy(css = "span[title='Сохранить'] > .button2__wrapper")
    private WebElement letterAddToDraft;

    @FindBy(css = "[title='Закрыть']")
    private WebElement letterClose;

    @FindBy(css = ".js-letter-list-item.js-tooltip-direction_letter-bottom.llc.llc_normal:nth-of-type(1)  .llc__content .ll-crpt")
    //[class='ll-crpt']
    public WebElement ToEnter;

    @FindBy(css = ".js-letter-list-item.js-tooltip-direction_letter-bottom.llc.llc_normal:nth-of-type(1)  .llc__content .ll-sj__normal")
    public WebElement SubjectEnter; //[class='ll-sj__normal']

    @FindBy(css = ".js-letter-list-item.js-tooltip-direction_letter-bottom.llc.llc_normal:nth-of-type(1)  .llc__content .ll-sp__normal")
    //[class='ll-sp__normal']
    public WebElement TextEnter;

    @FindBy(id = "PH_logoutLink")
    private WebElement buttonLogout;

    @FindBy(xpath = "//*[contains(text(), 'Отправленные')]")
    private WebElement sentButton;

    @FindBy(css = "span[title='Отправить'] > .button2__wrapper > .button2__txt")
    private WebElement sendLetterButton;

    @FindBy(css = "span[title='Закрыть']")
    private WebElement closeButton;

    public void authorization() {
        try {
            loginEnter.sendKeys(login);// ввода логина
            loginButton.click(); // кнопка - ввод пароля
            logger.info("Enter login");
        } catch (Exception e) {
            logger.error("Enter login in exception");
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(passEnter));//ожидание  элемента "ввод пароля"

            passEnter.sendKeys(pass);// ввод пароля
            passButton.click();//  кнопка - войти;
            logger.info("Enter password");

        } catch (Exception e) {
            logger.error("Enter password in exception");

        }
    }


    public void createMail() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(createLetterButton));

            createLetterButton.click();

            wait.until(ExpectedConditions.elementToBeClickable(subjectEnter));
            letterToEnter.sendKeys(To);
            subjectEnter.sendKeys(subject);
            letterKeysEnter.sendKeys(Text);
            logger.info("Method createMail has been passed");
        } catch (Exception e) {
            logger.error("Method createMail falls in exception");
        }

    }

    public void saveToDraft() {
        try {
            letterAddToDraft.click();
            letterClose.click();
            logger.info("Method saveToDraft has been passed");
        } catch (Exception e) {
            logger.error("Method saveToDraft falls in exception");
        }
    }

    public void openDraft() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(draftsButton));
            draftsButton.click();
            logger.info("Method openDraft has been passed");
        } catch (Exception e) {
            logger.error("Method openDraft falls in exception");
        }
    }

    public void sendMail() {

        try {
            sendLetterButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(closeButton));
            closeButton.click();
            logger.info("Method sendMail has been passed");
        } catch (Exception e) {
            logger.error("Method sendMail falls in exception" + e);
        }
    }

    public void openLetter() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(sentButton));
            sentButton.click();
            logger.info("Method openLetter has been passed");
        } catch (Exception e) {
            logger.error("Method openLetter falls in exception" + e);
        }

    }

    public void closeSession() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(buttonLogout));
            buttonLogout.click();
            wait.until(ExpectedConditions.elementToBeClickable(loginEnter));

            driver.quit();
            System.out.println("End test");

            logger.info("Method closeSession has been passed");

        }
        catch (Exception e) {
            logger.error("Method closeSession falls in exception" + e);
        }


    }
}
