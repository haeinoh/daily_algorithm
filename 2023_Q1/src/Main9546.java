import java.util.Scanner;

public class Main9546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int ts = 1; ts <= T; ts++) {
            int n = sc.nextInt();
            double end = 0;
            for(int i = 0; i < n; i++) {
                end += 0.5;
                end *= 2;
            }
            System.out.println((int)end);
        }
    }
}
