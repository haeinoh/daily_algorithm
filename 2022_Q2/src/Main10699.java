import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main10699 {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String str = dateFormat.format(today);
        System.out.println(str);
    }
}
