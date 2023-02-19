import java.util.Arrays;
import java.util.Scanner;

public class Main16439 {
    public static int n, m, answer;
    public static int[][] arr;
    public static void solve(int idx, int cnt, boolean[] vtd, int[] val) {
        if(cnt == 3) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int max = 0;
                for(int j = 0; j < val.length; j++) {
                    max = Math.max(max, arr[i][val[j]]);
                }
                sum += max;
            }
            answer = Math.max(sum, answer);
            return;
        }

        for(int i = idx; i < m; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                val[cnt] = i;
                solve(i, cnt+1, vtd, val);
                vtd[i] = false;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[] vtd = new boolean[m];
        int[] val = new int[3];
        solve(0, 0, vtd, val);

        System.out.println(answer);
    }
}
