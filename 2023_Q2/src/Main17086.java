import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17086 {
    public static int n, m;
    public static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[][] arr;
    public static int solve(int xx, int yy) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vtd = new boolean[n][m];
        q.add(new int[]{xx, yy});
        vtd[xx][yy] = true;

        int count = 0;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || vtd[nx][ny]) continue;
                    if(arr[nx][ny] == 1) {
                        count++;
                        break loop;
                    }
                    vtd[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
                size--;
            }
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    answer = Math.max(answer, solve(i, j));
                }
            }
        }

        System.out.println(answer);
    }
}
