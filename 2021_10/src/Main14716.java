import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14716 {
    public static int N, M, answer;
    public static int[][] arr;
    public static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    public static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    public static boolean[][] vtd;
    public static void solve(int valx, int valy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{valx, valy});
        vtd[valx][valy] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || vtd[nx][ny]) continue;
                    else {
                        vtd[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                 }
                size--;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[N][M];
        vtd = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1 && !vtd[i][j]) {
                    solve(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
