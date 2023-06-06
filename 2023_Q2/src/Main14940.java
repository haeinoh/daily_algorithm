import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main14940 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        int[][] ans = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        int count = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 0 || arr[nx][ny] == 2 || ans[nx][ny] != 0) continue;
                    ans[nx][ny] = count;
                    q.add(new int[]{nx, ny});
                }
                size--;
            }
            count++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && ans[i][j] == 0) sb.append("-1").append(" ");
                else sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
