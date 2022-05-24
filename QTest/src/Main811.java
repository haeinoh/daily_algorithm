import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main811 {
    public static int N;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[][] arr, dist;
    public static Queue<int[]> q;
    public static void bfs() {
        q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        arr[0][0] = 1;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1) continue;
                arr[nx][ny] = 1;
                q.offer(new int[]{nx,ny});
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = 7;
        arr = new int[N][N];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) cnt++;
            }
        }
        dist = new int[N][N];
        if(cnt == N*N) System.out.println("-1");
        else {
            bfs();
            System.out.println(dist[N-1][N-1]);
        }
    }
}

/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0

12
 */