import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1261 {
    public static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - 48;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        int[][] map = new int[n][m];
        for(int[] p: map) Arrays.fill(p, 987654321);
        map[0][0] = 0;
        boolean[][][] vtd = new boolean[n][m][2];
        vtd[0][0][0] = true;
        vtd[0][0][1] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node tmp = q.poll();
                int x = tmp.x;
                int y = tmp.y;
                int cnt = tmp.cnt;

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || vtd[nx][ny][arr[x][y]]) continue;

                    if(map[nx][ny] > map[x][y] + cnt) {
                        if(arr[nx][ny] == 1) {
                            map[nx][ny] = map[x][y] + 1;
                            q.add(new Node(nx, ny, cnt+1));
                        } else {
                            map[nx][ny] = map[x][y];
                            q.add(new Node(nx, ny, cnt));
                        }
                    }

                    vtd[nx][ny][arr[x][y]] = true;
                }
                size--;
            }
        }
//        for(int p[]: map) System.out.println(Arrays.toString(p));

        System.out.println(map[n-1][m-1]);
    }
}
