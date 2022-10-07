import java.util.Scanner;

public class Main16433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(((r % 2 == i % 2) && (c % 2 == j %2)) || ((r % 2 != i % 2) && (c % 2 != j %2))) sb.append("v");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
