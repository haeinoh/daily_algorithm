import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main188009 {
    public static int N, M, G, R, answer, size;
    public static int[] comb;
    public static int[][] arr, store;
    public static boolean[] visited;
    public static boolean[][][] vtd;
    public static Queue<Color> q;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static class Color {
        int x;
        int y;
        int col;
        int time;

        public Color(int x, int y, int col, int time) {
            this.x = x;
            this.y = y;
            this.col = col;
            this.time = time;
        }
    }
    public static void spread() {
        //init
        int[][] board = new int[N][M];
        for(int i = 0; i < N; i++)
             for(int j = 0; j < M; j++)
                 board[i][j] = arr[i][j];

             //board[i][j] = new Color();... .
        q = new LinkedList<>();
        vtd = new boolean[N][M][5];
        // G , R
        for(int i = 0; i < G; i++) {
            int x = store[comb[i]][0];
            int y = store[comb[i]][1];
            board[x][y] = 3;
            vtd[x][y][3] = true;
            q.add(new Color(x, y, 3, 0));
        }
        for(int i = G; i < comb.length; i++) {
            int x = store[comb[i]][0];
            int y = store[comb[i]][1];
            board[x][y] = 4;
            vtd[x][y][4] = true;
            q.add(new Color(x, y, 4, 0));
        }

        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Color tmp = q.poll();
                int x = tmp.x;
                int y = tmp.y;
                int color = tmp.col;
                int time = tmp.time;

                for(int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 0 || board[nx][ny] == 5 || vtd[nx][ny][color]) continue;
                     else {
                         if((board[nx][ny] == 3 && board[x][y] == 4) || (board[nx][ny] == 4 && board[x][y] == 3)) {
                            count++;
                            board[nx][ny] = 5;
                         } else {
                             q.add(new Color(nx, ny, color, time));
                             board[nx][ny] = color;
                         }
                         vtd[nx][ny][color] = true;
                    }
                }
                size--;
            }
        }
        System.out.println(count);
        answer = Math.max(answer, count);
    }

    public static void solve(int cnt) {
        if(cnt == G + R){
            spread();
            return;
        }

        for(int i = 0; i < size; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb[cnt] = i;
                solve(cnt+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        store = new int[N*M][2];
        answer = 0;
        size = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    store[size][0] = i;
                    store[size][1] = j;
                    size++;
                }
            }
        }

        comb = new int[G+R];
        visited = new boolean[size];
        solve(0);
        System.out.println(answer);
    }
}
