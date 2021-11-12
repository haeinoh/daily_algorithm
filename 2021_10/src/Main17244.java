import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17244 {
    public static int N, M, goods, answer;
    public static char[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static boolean[][][] vtd;
    public static Queue<Um> q;
    public static class Um {
        int x;
        int y;
        int go;

        public Um(int x, int y, int go) {
            this.x = x;
            this.y = y;
            this.go = go;
        }
    }
    public static void solve() {
        int cnt = 0;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Um tmp = q.poll();
                int x = tmp.x;
                int y = tmp.y;
                int go = tmp.go;

                if(arr[x][y] == 'E') {
                    System.out.println("enter " + go);
                    System.out.println(1 << goods);
                    answer = Math.min(answer, cnt);
                    break loop;
                }

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#' || vtd[nx][ny][go]) continue;
                    else {
                        if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f') {
                            int key = go | 1 << (arr[nx][ny] - 'a');
                            // || vtd[nx][ny][go & 1 << (arr[nx][ny] - 'a')]
                            System.out.println(" ======  " + nx + " " + ny);
                            System.out.println(go + " " + arr[nx][ny] + " " + key);
                            vtd[nx][ny][key] = true;
                            q.add(new Um(nx, ny, key));
                        } else {
                            vtd[nx][ny][go] = true;
                            q.add(new Um(nx, ny, go));
                        }
                    }
                }
                size--;
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        answer = 987654321;
        goods = 0;
        arr = new char[N][M];
        vtd = new boolean[N][M][1 << 6];
        q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'X') {
                    arr[i][j] = (char) (goods + 'a');
                    goods++;
                } else if(arr[i][j] == 'S') {
                    q.add(new Um(i, j, 0));
                    vtd[i][j][0] = true;
                }
            }
        }

        System.out.println(1 << 6);
        System.out.println(3 & 1 << ('b' - 'a'));

        solve();

        System.out.println(answer);
    }
}
