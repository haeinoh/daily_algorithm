import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1992 {
    public static int N;
    public static int[][] arr;
    public static StringBuilder sb;
    public static void solve(int n, int x, int y) {
        if(n == 1) {
            sb.append(String.valueOf(arr[x][y]));
            return;
        }

        if(check(n, x, y)) {
            return;
        }

        sb.append("(");
        solve(n/2, x, y);
        solve(n/2, x, y+n/2);
        solve(n/2, x+n/2, y);
        solve(n/2, x+n/2, y+n/2);
        sb.append(")");
    }

    public static boolean check(int n, int x, int y) {
        int flag = arr[x][y];
        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if(flag != arr[i][j]) return false;
            }
        }
        sb.append(String.valueOf(flag));
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        solve(N, 0, 0);
        System.out.println(sb.toString());
    }
}