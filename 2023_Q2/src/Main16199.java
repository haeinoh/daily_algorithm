import java.util.Scanner;

public class Main16199 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int ay = sc.nextInt();
        int am = sc.nextInt();
        int ad = sc.nextInt();

        if(ay - y > 0 && (am - m > 0 || (am - m == 0 && ad - d >= 0))) System.out.println(ay - y );
        else if(ay - y == 0) System.out.println("0");
        else System.out.println(ay - y - 1);
        System.out.println(ay - y + 1);
        System.out.println(ay - y);
    }
}
