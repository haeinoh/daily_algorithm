import java.util.Scanner;

public class Main2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int val = sc.nextInt();
            sb.append(val/25).append(" ");
            val %= 25;
            sb.append(val/10).append(" ");
            val %= 10;
            sb.append(val/5).append(" ");
            sb.append(val%5).append("\n");
        }
        System.out.println(sb.toString());
    }
}
