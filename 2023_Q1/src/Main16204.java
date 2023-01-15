import java.util.Scanner;

public class Main16204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(Math.min(m, k) + Math.min((n-m), (n-k)));
    }
}
