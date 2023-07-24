import java.util.Scanner;

public class Main25600 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            int ans = a * (d + g);

            if(a == (d + g)) ans *= 2;
            sum = Math.max(sum ,ans);
        }
        System.out.println(sum);
    }
}
