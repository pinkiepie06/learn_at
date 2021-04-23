import java.util.Date;
import java.text.SimpleDateFormat;

public class CurrentDate {
    static Date Date = new Date();
    static SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
   static String currentDate = formatDate.format(Date);
}
