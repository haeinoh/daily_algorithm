import java.util.Scanner;

public class Main11006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int ts = 1; ts <= T; ts++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println((b-(a-b)) + " " + (a-b));
        }
    }
}
