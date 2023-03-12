import java.util.Scanner;

public class Main23809 {
    public static int n;
    public static StringBuilder sb;
    public static void step(int val) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) sb.append("@");
            for(int j = 0; j < n*val; j++) sb.append(" ");
            for(int j = 0; j < n; j++) sb.append("@");
            sb.append("\n");
        }
    }
    public static void mid() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n*3; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sb = new StringBuilder();

        step(3);
        step(2);
        mid();
        step(2);
        step(3);

        System.out.println(sb.toString());
    }
}
