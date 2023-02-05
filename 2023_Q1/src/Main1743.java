import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1743 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[][] arr;
    public static boolean[][] vtd;

    public static int solve(int n, int m, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        vtd[x][y] = true;
        int cnt = 1;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int xx = tmp[0];
            int yy = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 0 || vtd[nx][ny]) continue;
                vtd[nx][ny] = true;
                q.add(new int[]{nx, ny});
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n][m];
        for(int i = 0; i < k; i++) {
            arr[sc.nextInt()-1][sc.nextInt()-1]++;
        }

        vtd = new boolean[n][m];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vtd[i][j] && arr[i][j] > 0) {
                    answer = Math.max(solve(n, m, i, j), answer);
                }
            }
        }

        System.out.println(answer);
    }
}
