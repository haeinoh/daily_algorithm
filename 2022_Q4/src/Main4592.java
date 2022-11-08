import java.io.IOException;
import java.util.Scanner;

public class Main4592 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            int prev = sc.nextInt();
            sb.append(prev).append(" ");
            for(int i = 1; i < n; i++) {
                int value = sc.nextInt();
                if(prev == value) continue;
                prev = value;
                sb.append(value).append(" ");
            }
            sb.append("$").append("\n");
        }
        System.out.println(sb.toString());
    }
}
