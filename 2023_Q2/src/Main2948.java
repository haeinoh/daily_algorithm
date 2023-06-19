import java.util.Scanner;

public class Main2948 {
    public static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String[] day = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int m = sc.nextInt();

        int calc = 0;
        if(m - 2 >= 0) { for(int i = 0; i < m-1; i++) calc += month[i]; }
        calc += d - 1;
        System.out.println(day[calc%7]);
    }
}
