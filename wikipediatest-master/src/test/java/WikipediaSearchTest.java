import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;

public class WikipediaSearchTest extends AppiumSettings {
    public static AppiumDriver driver;
    @Before
    public void setCapabilities()throws Exception{
    File app = new File (PATHNAME);
    URL serverURL = new URL(URLSPEC);
    DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORMNAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORMVERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICENAME);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", APPPACKAGE);
        capabilities.setCapability("appActivity", APPACTIVITY);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("udid", Device_ID);
        capabilities.setCapability("dontStopAppOnReset", "true");
        driver = new AndroidDriver(serverURL, capabilities);
    }
    @Test
    public void testFindTest() throws Exception{
        Assert.assertNotNull(driver.findElement(By.id(mainPage)));
        driver.findElement(By.id(scipBotton)).click();
        driver.findElement(By.xpath(textBox)).clear();
        driver.findElement(By.id(searchBox)).sendKeys(inputText);
        driver.findElement(By.xpath(firstSearchResult)).click();

        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath(testHead)).getText().contains(inputText));
        }

    @After
    public  void  close() {
       driver.quit();
    }
}
