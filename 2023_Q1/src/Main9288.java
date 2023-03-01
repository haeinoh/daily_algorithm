import java.util.Scanner;

public class Main9288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            int val = sc.nextInt();
            sb.append("Case ").append(i).append(":\n");
            for(int j = 1; j <= val/2; j++) {
                if(j <= 6 && val-j <= 6) sb.append("(").append(j + "," + (val-j)).append(")\n");
            }
        }
        System.out.println(sb.toString());
    }
}
