import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main20058 {
    public static int[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int N, Q;
    public static void solve(int level) {
        


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < Q; i++) {
            int value = Integer.parseInt(st.nextToken());
            solve(value);
        }

        int max = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, arr[i][j]);
                sum += arr[i][j];
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(arr[i][j] == max) cnt++;

        System.out.println(sum);
        System.out.println(cnt);
    }
}
