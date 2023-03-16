import java.util.Scanner;

public class Main13240 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) sb.append("*");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
