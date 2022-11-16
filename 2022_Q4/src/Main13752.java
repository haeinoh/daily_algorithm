import java.util.Scanner;

public class Main13752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            sb.append("=".repeat(Math.max(0, value)));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
