import java.util.Scanner;

public class Main18883 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(num++);
                if(j < m -1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}