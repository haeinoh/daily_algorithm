import java.util.Scanner;

public class Main2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int seconds = sc.nextInt();

        s += seconds;
        m += s/60;
        s %= 60;
        h += m/60;
        m %= 60;
        h %= 24;

        System.out.println(h + " " + m + " " + s);
    }
}
