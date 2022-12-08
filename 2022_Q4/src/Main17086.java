import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17086 {
    public static int N, M, answer;
    public static int[][] arr;
    public static boolean[][] vtd;

    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void solve(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        vtd[sx][sy] = true;
        q.add(new int[] {sx, sy});
        int cnt = 0;
        boolean flag = false;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                for(int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || vtd[nx][ny]) continue;
                    if(arr[nx][ny] == 1) {
                        cnt++;
                        answer = Math.min(answer, cnt);
                        flag = true;
                        break loop;
                    }
                    vtd[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
                size--;
            }
            cnt++;
        }
        System.out.println(answer + " " + cnt);
        if(!flag) answer = Math.min(answer, --cnt);
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        vtd = new boolean[N][M];
        answer = 987654321;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) {
                    solve(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
