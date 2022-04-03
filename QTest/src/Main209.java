import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main209 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int row = 0;
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                row += arr[i][j];
            }
            max = Math.max(row, max);
        }

        int left = 0;
        int right = 0;
        for(int i = 0; i < N; i++) {
            int col = 0;
            for(int j = 0; j < N; j++) {
                col += arr[j][i];
            }
            left += arr[i][i];
            right += arr[N-i-1][N-i-1];
            max = Math.max(col, max);
        }

        System.out.println(Math.max(max, Math.max(left, right)));
    }
}
