import java.util.Scanner;

public class Main19532 {
    public static int a, b, c, d, e, f, x, y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        f = sc.nextInt();
        x = 0;
        y = 0;
        for(int i = -999; i <= 999; i++) {
            for(int j = -999; j <= 999; j++) {
                if((a*i + b*j == c) && (d*i + e*j == f)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
