import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3187 {
    public static int R, C, wolves, sheep;
    public static char[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static boolean[][] vtd;
    public static void solve(int r, int c) {
        vtd[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        int wo = 0;
        int sh = 0;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == '#' || vtd[nx][ny]) continue;
                if (arr[nx][ny] == 'v') wo++;
                else if (arr[nx][ny] == 'k') sh++;
                vtd[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        if(wo < sh) wolves -= wo;
        else sheep -= sh;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        wolves = 0;
        sheep = 0;
        arr = new char[R][C];
        vtd = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String str = sc.next();
            for(int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'v') wolves++;
                else if(arr[i][j] == 'k') sheep++;
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == '.' && !vtd[i][j]) {
                    solve(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolves);
    }
}
