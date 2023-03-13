import java.util.Scanner;

public class Main23810 {
    public static int n;
    public static StringBuilder sb;
    public static void first() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n*5; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }
    public static void second(int tmp) {
        for(int i = 0; i < tmp*n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sb = new StringBuilder();

        first();
        second(1);
        first();
        second(2);

        System.out.println(sb.toString());
    }
}
