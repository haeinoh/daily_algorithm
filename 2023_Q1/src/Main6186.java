import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main6186 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static char[][] arr;
    public static boolean[][] vtd;
    public static void solve(int x, int y, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        vtd[x][y] = true;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int xx = tmp[0];
            int yy = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c || vtd[nx][ny] || arr[nx][ny] == '.') continue;
                q.add(new int[]{nx, ny});
                vtd[nx][ny] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        arr = new char[r][c];
        vtd = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String str = sc.next();
            for(int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int answer = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[i][j] == '#' && !vtd[i][j]) {
                    solve(i, j, r, c);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
