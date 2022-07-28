import java.util.Scanner;

public class Main10103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int chang = 100;
        int sang = 100;
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a < b) chang -= b;
            else if(a > b) sang -= a;
        }
        System.out.println(chang);
        System.out.println(sang);
    }
}
