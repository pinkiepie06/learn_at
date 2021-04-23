import org.testng.annotations.*;

public class taskAnnotations {


   @Parameters({"username", "city"})
    @Test
    public void testAuto1(@Optional("Optional_demo_username")String username, @Optional("Optional_demo_city")String city) {

        System.out.print(username + " " + city + " " + CurrentDate.currentDate);
    }


}

