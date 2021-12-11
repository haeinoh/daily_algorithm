import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4991 {
    public static int N, M, answer, len;
    public static char[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static Queue<Clean> q;
    public static boolean[][][] vtd;
    public static boolean flag;
    public static class Clean {
        int x;
        int y;
        int key;

        public Clean(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
    public static void solve() {
        answer = 0;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Clean tmp = q.poll();
                int x = tmp.x;
                int y = tmp.y;
                int key = tmp.key;
                if(key == (1 << len) - 1) {
                    flag = true;
                    break loop;
                }

                for(int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 'x' || vtd[nx][ny][key]) continue;
                    else {
                        int tmpKey = key;
                        if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'k') {
                            tmpKey = key | 1 << arr[nx][ny] - 'a';
                        }
                        q.add(new Clean(nx, ny, tmpKey));
                        vtd[nx][ny][tmpKey] = true;
                    }
                }
                size--;
            }
            answer++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0)break;
            arr = new char[N][M];
            q = new LinkedList<>();
            len = 97;
            flag = false;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                String str = st.nextToken();
                for(int j = 0; j < M; j++) {
                    arr[i][j] = str.charAt(j);
                    if(arr[i][j] == 'o') {
                        q.add(new Clean(i, j, 0));
                    } else if(arr[i][j] == '*') {
                        arr[i][j] = (char) len;
                        len++;
                    }
                }
            }
            len-=97;
            vtd = new boolean[N][M][1<<len];
            solve();
            if(flag) sb.append(answer).append("\n");
            else sb.append("-1").append("\n");
        }
        System.out.println(sb.toString());
    }
}
