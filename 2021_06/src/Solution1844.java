import java.util.LinkedList;
import java.util.Queue;

public class Solution1844 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int n, m;
    public static int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vtd = new boolean[n][m];
        q.add(new int[] {0, 0});
        vtd[0][0] = true;
        boolean flag = false;

       loop:while(!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                if(x == n-1 && y == m-1) {
                    flag = true;
                    answer++;
                    break loop;
                }
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || vtd[nx][ny] || maps[nx][ny] == 0) continue;

                    vtd[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
                size--;
            }
            answer++;
        }

        if(!flag) answer = -1;
        return answer;
    }
    public static void main(String[] args) {
        int[][] m = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1},{0,0,0,0,1}, {0,0,0,0,1}};
        System.out.println(solution(m));
    }
}
