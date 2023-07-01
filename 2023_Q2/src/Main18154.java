import java.util.Scanner;

public class Main18154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int pt = sc.nextInt();
        int pd = sc.nextInt();
        int max = 0;
        for(int i = 1; i < N; i++) {
            int t = sc.nextInt();
            int d = sc.nextInt();
            max = Math.max(max, (d-pd)/(t-pt));

            pt = t;
            pd = d;
        }
        System.out.println(max);
    }
}
