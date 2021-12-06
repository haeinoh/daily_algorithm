import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17141 {
    public static int N, M, answer, length;
    public static int[][] arr, virus;
    public static int[] comb;
    public static boolean[] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void spread(int[][] arr) {
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = arr[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vtd = new boolean[N][N];

        for(int i = 0; i < comb.length; i++) {
            int x = virus[comb[i]][0];
            int y = virus[comb[i]][1];
            board[x][y] = 3;
            vtd[x][y] = true;
            q.add(new int[]{x, y});
        }

        int turn = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || vtd[nx][ny] || board[nx][ny] == 1) continue;
                    else {
                        vtd[nx][ny] = true;
                        board[nx][ny] = 3;
                        q.add(new int[]{nx, ny});
                    }
                }
                size--;
            }
            turn++;
        }
        boolean flag = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }
        if(!flag) answer = Math.min(answer, turn);
    }

    public static void solve(int cnt, int idx) {
        if(cnt == M) {
            spread(arr);
            return;
        }

        for(int i = idx; i < length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb[cnt] = i;
                solve(cnt+1, i);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 987654321;
        length = 0;
        arr = new int[N][N];
        virus = new int[N*N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    virus[length][0] = i;
                    virus[length][1] = j;
                    length++;
                }
            }
        }

        comb = new int[M];
        visited = new boolean[length];
        solve(0, 0 );

        if(answer == 987654321) System.out.println("-1");
        else System.out.println(answer-1);
    }
}
