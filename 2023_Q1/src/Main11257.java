import java.util.Scanner;

public class Main11257 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int candidate = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            sb.append(candidate).append(" ").append(a + b + c).append(" ");

            if(35*0.3 <= a && 25*0.3 <= b && 40*0.3 <= c && (a+b+c) >= 55) sb.append("PASS");
            else sb.append("FAIL");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
