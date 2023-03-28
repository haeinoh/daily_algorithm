import java.util.Scanner;

public class Main23794 {
    public static StringBuilder sb;
    public static void step1(int n) {
        for(int i = 0; i < n+2; i++) sb.append("@");
        sb.append("\n");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sb = new StringBuilder();
        step1(n);
        for(int i = 0; i < n; i++) {
            sb.append("@");
            for(int j = 0; j < n; j++) sb.append(" ");
            sb.append("@").append("\n");
        }
        step1(n);
        System.out.println(sb.toString());
    }
}
