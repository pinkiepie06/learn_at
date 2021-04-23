package ru.yandex.pages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.tests.WebDriverSettings;
import java.io.File;
import static ru.yandex.Log.logger;
/*
Self framework methods
*/

public class BasePage extends WebDriverSettings {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void getscreenshot() throws Exception {
        //The below method will save the screen shot in d drive with name "screenshot.png"
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("\\screenshot\\screenshot.png"));
        logger.error("Taking screenshot");
    }
    public void openPage(String urlGet){
        driver.get(urlGet);
    }
    public void clickElement(WebElement elementToClick) throws Exception {
        try{
        logger.info("click on element" + elementToClick.getTagName());
        elementToClick.click();
    }
        catch (Exception e){
            logger.error("I'm in exception");
//calls the method to take the screenshot.
            this.getscreenshot();
        }

    }
    public void inputTextAssert(String textToinput, WebElement inputField)  {
        this.clearField(inputField);
        inputField.sendKeys(textToinput);
        Assert.assertEquals(inputField.getAttribute("value"), textToinput);
    }
    public void inputText(Strin g textToinput, WebElement inputField)  {
        this.clearField(inputField);
        inputField.sendKeys(textToinput);
    }
    public void clearField(WebElement fieldToClear){
        fieldToClear.clear();
    }
}
