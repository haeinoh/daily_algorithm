import java.util.Scanner;

public class Main10995 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) for(int j = 0; j < n; j++) sb.append("* ");
            else for(int j = 0; j < n; j++) sb.append(" *");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
