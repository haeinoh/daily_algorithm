import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16948 {
    public static int[] dx = {-2, -2, 0, 0, 2, 2};
    public static int[] dy = {-1, 1, -2, 2, -1, 1};
    public static int solve(int n, int r, int c, int r1, int c1) {
        int answer = 0;
        boolean[][] vtd = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        vtd[r][c] = true;
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

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || vtd[nx][ny]) continue;
                    else if(nx == r1 && ny == c1) {
                        answer++;
                        flag = true;
                        break loop;
                    } else {
                        q.add(new int[]{nx, ny});
                        vtd[nx][ny] = true;
                    }
                }
                size--;
            }
            answer++;
        }

        if(!flag) return -1;
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.println(solve(n, r, c, r1, c1));
    }
}
