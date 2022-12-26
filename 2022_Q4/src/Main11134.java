import java.util.Scanner;

public class Main11134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int val = n % m;
            System.out.println(n/m + (val > 0? 1 : 0));
        }
    }
}
