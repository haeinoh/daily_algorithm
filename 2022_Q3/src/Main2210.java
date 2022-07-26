import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2210 {
    public static int N;
    public static int[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static HashSet<String> set;
    public static void solve(int sx, int sy, int cnt, String str) {
        if(cnt == N) {
            set.add(str);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            else solve(nx, ny, cnt+1, str + arr[nx][ny]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                solve(i, j, 0, String.valueOf(arr[i][j]));
            }
        }

        System.out.println(set.size());
    }
}
