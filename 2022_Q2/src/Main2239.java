import java.util.Arrays;
import java.util.Scanner;

public class Main2239 {
    public static int[][] arr ;
    public static void solve(int x, int y) {


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9][9];
        for(int i = 0; i < 9; i++) {
            String str = sc.next();
            for(int j = 0; j < 9; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        solve(0, 0);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
