import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main811 {
    public static int N, M, answer;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[][] arr;
    public static boolean[][] vtd;
    public static Queue<int[]> q;
    public static void bfs() {
        q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean flag = false;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                if(x == N-1 && y == M-1) {
                    flag = true;
                    break;
                }
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != 0 || vtd[nx][ny]) continue;
                    vtd[nx][ny] = true;
                }
                size--;
            }
            answer++;
        }
        if(!flag) answer = -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        answer = 0;
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) cnt++;
            }
        }

        if(cnt == N*M) System.out.println("0");
        else {
            bfs();
            System.out.println(answer);
        }
    }
}
