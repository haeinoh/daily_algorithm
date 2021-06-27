import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1829 {
    public static boolean[][] vtd;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int solve(int m, int n, int[][] picture, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        vtd[x][y] = true;
        int color = picture[x][y];
        int size = 1;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int xx = tmp[0];
            int yy = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || vtd[nx][ny] || color != picture[nx][ny]) continue;

                vtd[nx][ny] = true;
                q.add(new int[]{nx, ny});
                size++;
            }
        }
        return size;
    }
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        vtd = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !vtd[i][j]) {
                    int size = solve(m, n, picture, i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution(m, n, pic)));
    }
}
