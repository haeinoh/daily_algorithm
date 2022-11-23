import java.util.Scanner;

public class Main20299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int L = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if((a + b + c) >= K && a >= L && b >= L && c >= L) {
                count++;
                sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
