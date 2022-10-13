import java.util.Scanner;

public class Main15232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            sb.append("*".repeat(Math.max(0, c)));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
