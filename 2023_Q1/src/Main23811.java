import java.util.Scanner;

public class Main23811 {
    public static int n;
    public static StringBuilder sb;
    public static void step1() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n*5; j++) sb.append("@");
            sb.append("\n");
        }
    }
    public static void step2() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) sb.append("@");
            sb.append("\n");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sb = new StringBuilder();

        step1();
        step2();
        step1();
        step2();
        step1();

        System.out.println(sb.toString());
    }
}
