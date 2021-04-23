package ru.mail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.mail.pageobject.Logic;
import ru.mail.pageobject.MailPage;
import static logs.ru.mail.Log.logger;


public class TestMail extends WebDriverSettings {

    public static MailPage mailBase;

    @BeforeClass(description = "Открытие сайта mail.ru")
    public void browserSetting() throws Exception {
        mailBase = new MailPage(driver);//из webDrSettings
        driver.get(mainMailUrl);
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Mail.ru: почта, поиск в интернете, новости, игры"));
        logger.info("Page mail.ru has been opened");
        mailBase.authorization();


    }

    @Test(priority = 0)
    public void SaveMailToDraft()  {

        mailBase.createMail();
        mailBase.saveToDraft();
    }

    @Test(priority = 1)

    public void CompareDraft()  {
        mailBase.openDraft();
        Logic.сompare(mailBase.subject, mailBase.SubjectEnter);
        Logic.сompare(mailBase.To, mailBase.ToEnter);
        Logic.сompare(mailBase.Text, mailBase.TextEnter);

    }

    @Test(priority = 2)
    public void SendLetter()  {

        mailBase.createMail();
        mailBase.sendMail();


    }

   @Test(priority = 3)
    public void CompareLetter()  {

        mailBase.openLetter();
       Logic.сompare(mailBase.subject, mailBase.SubjectEnter);

       Logic.сompare(mailBase.To, mailBase.ToEnter);
       Logic.сompare(mailBase.Text, mailBase.TextEnter);
    }


 @AfterClass
    public void CloseSession() {
        mailBase.closeSession();


}
}