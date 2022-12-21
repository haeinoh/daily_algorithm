import java.util.Scanner;

public class Main4084 {
    public static boolean same(int a , int b, int c, int d) {
        if(a == b && b == c && c == d) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            if(a == 0 && b == 0 && c == 0 && d == 0) break;
            int cnt = 0;
            while(same(a, b, c, d)) {
                int tmp = a;
                a = Math.abs(a - b);
                b = Math.abs(b - c);
                c = Math.abs(c - d);
                d = Math.abs(d - tmp);
                cnt++;
            }
            System.out.println(cnt);
        }

    }
}
