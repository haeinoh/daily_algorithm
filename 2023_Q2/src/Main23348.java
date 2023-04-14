import java.util.Scanner;

public class Main23348 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int N = sc.nextInt();

        int sum = 0;
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            for(int j = 0; j < 3; j++) {
                int p = sc.nextInt();
                int q = sc.nextInt();
                int r = sc.nextInt();
                tmp += p*a + q*b + r*c;
            }
            sum = Math.max(sum ,tmp);
        }
        System.out.println(sum);
    }
}
