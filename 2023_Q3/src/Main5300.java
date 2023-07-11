import java.util.Scanner;

public class Main5300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            sb.append(i).append(" ");
            if(i % 6 == 0) sb.append("Go! ");
        }
        if(n % 6 != 0) sb.append("Go! ");
        System.out.println(sb.toString());
    }
}
