import java.util.Scanner;

public class Main23808 {
    public static StringBuilder sb;
    public static int n;
    public static void num1() {
        for(int j = 0; j < n; j++) sb.append("@");
        for(int j = 0; j < n*3; j++) sb.append(" ");
        for(int j = 0; j < n; j++) sb.append("@");
        sb.append("\n");
    }

    public static void num2() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n*5; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sb = new StringBuilder();

        for(int i = 0; i < n*2; i++) num1();

        num2();

        for(int i = 0; i < n; i++) num1();

        num2();

        System.out.println(sb.toString());
    }
}
