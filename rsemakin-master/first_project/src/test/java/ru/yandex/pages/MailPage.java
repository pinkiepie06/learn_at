package ru.yandex.pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.tests.WebDriverSettings;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeborne.selenide.Selenide.$;
import static ru.yandex.Log.logger;
import static org.testng.Assert.assertTrue;
import static ru.yandex.settings.User.EMAIL;
import static ru.yandex.settings.User.PASSWORD;

/*
Email page on mail.yandex.ru selectors and methods
 */

public class MailPage extends WebDriverSettings {
     public MailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    YANDEXHOMEURL
    @FindBy (className="HeadBanner-Button-Enter")
    private WebElement loginButton;
    @FindBy (id="passp-field-login")
    public WebElement inputLogin;
    @FindBy (id="passp-field-passwd")
    private WebElement inputPassword;
    @FindBy (css=".Button2_view_action.Button2_size_auth-l")
    private WebElement authButton;
    @FindBy (className="mail-ComposeButton-Text")
    private WebElement writeMailButton;
    @FindBy (css=".tst-field-to .composeYabbles")
    private WebElement inputToEmail;
    @FindBy (className="ComposeControlPanelButton-Button_action")
    private WebElement sendEmail;
    @FindBy (css="span[title='aroman2012@yandex.ru']")
    private WebElement inboxTitle;
    @FindBy (xpath = "//span[text()='Черновики']")
    private  WebElement draftEmailButton;


    public void authorization() throws Exception{
        logger.info("Start auth");
        basePage.clickElement(loginButton);
        basePage.inputTextAssert(EMAIL, inputLogin);
        basePage.clickElement(authButton);
        basePage.inputTextAssert(PASSWORD, inputPassword);
        basePage.clickElement(authButton);
        WebDriverWait wait = new WebDriverWait(driver,PAGELOADTIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(writeMailButton));
        assertTrue(driver.getTitle().contains(expectedTitle));
        }
    public void createEmail() throws Exception{
        basePage.clickElement(writeMailButton);
        basePage.inputText(EMAIL, inputToEmail);
    }
    public void sendEmail() throws Exception{
        basePage.clickElement(sendEmail);
    }
    public void ckeckInbox(){
        WebDriverWait wait = new WebDriverWait(driver,PAGELOADTIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(inboxTitle));
    }
    public void clickDraft() throws Exception{basePage.clickElement(draftEmailButton);}
}
