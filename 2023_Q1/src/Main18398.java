import java.util.Scanner;

public class Main18398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int ts = 1; ts <= T; ts++) {
            int N = sc.nextInt();
            for(int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                sb.append(a+b).append(" ").append(a*b).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
