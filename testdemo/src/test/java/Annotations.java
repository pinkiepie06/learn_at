import org.testng.annotations.*;

public class Annotations {

   /* @BeforeSuite
    public void setUp() {
        System.out.println("BeforeSuite Setup will be run one time");
    }

    @BeforeTest
    public void profileSetup() {
        System.out.println("BeforeTest1 profileSetup will be run one time");
    }

    @BeforeMethod
    public void checkLogin() {
        System.out.println("BeforeMethod checkLogin will be run each time when test runs");
    }*/

    @Test (priority = 1)
    public void testDemo() {
    System.out.println("Test annotation1");
    }

    @BeforeTest
    public void before2() {
        System.out.println("BeforeTest2 profileSetup will be run one time");
    }


    @Parameters({"username", "password"})
    @Test (priority = 0)
    public void testDemo2(@Optional("Optional_demo_username") String username, @Optional("Optional_demo_password") String password) {
        System.out.println("Test annotation2 username: " + username);
        System.out.println("Test annotation2 password: " + password);
    }

    @AfterTest
    public void reportReady() {
        System.out.println("Report is ready to be shared, with screenshots of tests will be run one time");
    }
    @AfterMethod
    public void screenShot() {
        System.out.println("AfterMethod: screenShot will be run each time after each test runs");
    }

}
