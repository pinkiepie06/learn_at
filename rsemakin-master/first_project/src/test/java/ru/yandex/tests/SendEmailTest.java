package ru.yandex.tests;
//import io.qameta.allure.Step;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.pages.BasePage;
import ru.yandex.pages.MailPage;
import static ru.yandex.Log.logger;

/*
Two tests for yandex Email sending and draft email creation
*/


public class SendEmailTest extends WebDriverSettings {
    public static MailPage mailPage;
    public static BasePage basePage;
  //  @Step("Setup step with authorization")
    @BeforeClass
    public  void setupTest() throws Exception{
        mailPage = new MailPage(driver);
        basePage = new BasePage(driver);
        //     logger.info("Setup run");
        basePage.openPage(YANDEXHOMEURL);
        mailPage.authorization();
    }
    //   @Step("Send email test")
    @Test
    public void sendEmailTest() throws Exception{
        //     logger.info("Send email test run");
        mailPage.createEmail();
        mailPage.sendEmail();
        basePage.openPage(YANDEXHOMEURL);
    }
    //  @Step("Create draft email test")
    @Test
    public void draftEmailTest() throws Exception{
        //   logger.info("Create draft email test run");
        //mailPage.createEmail();
        mailPage.clickDraft();
    }
    //  @Step("Check test run")
    @AfterClass
    public void checkRun(){mailPage.ckeckInbox();}
}
