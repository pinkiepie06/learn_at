import java.text.SimpleDateFormat;

public class Print {
    public static void printLine() {
        SimpleDateFormat toFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.print(Params.Username + " " + Params.City + " " + toFormat.format(Params.currentDate));
    }
}