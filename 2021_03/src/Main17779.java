//https://www.acmicpc.net/problem/17779
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17779 {
    public static int N, answer;
    public static int[] comb, count;
    public static int[][] arr, map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void counting() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                count[arr[i][j]] += map[i][j];
            }
        }
        Arrays.sort(count);
        int num = 0;
        for(int i = N-1; i >=0; i--) {
            if(count[i] == 0) break;
            else num = i;
        }
        answer = Math.min(answer, (count[N] - count[num]));
        for(int i = 0; i <= N; i++) {
            count[i] = 0;
        }
    }

    public static void five() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,1});
        q.add(new int[]{1, N});
        q.add(new int[]{N, 1});
        q.add(new int[]{N, N});
        arr[1][1] = -1;
        arr[1][N] = -1;
        arr[N][1] = -1;
        arr[N][N] = -1;
        while(!q.isEmpty()) {
            int tmp[] = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx <= 0 || ny <= 0 || nx >= N+1 || ny >= N+1 || arr[nx][ny] == 5) continue;
                else if(arr[nx][ny] == 0) {
                    arr[nx][ny] = -1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        // .. 5
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(arr[i][j] != -1) arr[i][j] = 5;
                else if(arr[i][j] != 5) arr[i][j] = 0;
            }
        }

    }

    public static void dist(int x, int y, int d1, int d2) { // 4) 구역 나누기
        five();
        // .. 1
        for(int i = 1; i < x+d1; i++) {
            for(int j = 1; j <= y; j++) {
                if(arr[i][j] == 0) arr[i][j] = 1;
            }
        }

        // .. 2
        for(int i = 1; i <= x + d2; i++) {
            for(int j = y+1; j <= N; j++) {
                if(arr[i][j] == 0) arr[i][j] = 2;
            }
        }

        // .. 3
        for(int i = x+d1; i <= N; i++) {
            for(int j = 1; j < y-d1+d2; j++) {
                if(arr[i][j] == 0) arr[i][j] = 3;
            }
        }

        // .. 4
        for(int i = x+d2+1; i <= N; i++) {
            for(int j = y-d1+d2; j <= N; j++) {
                if(arr[i][j] == 0) arr[i][j] = 4;
            }
        }
        counting();
    }

    public static void solve(int x, int y, int d1, int d2) { // 3) 경계선 구하기
        // ..1
        int nx = x;
        int ny = y;
        while(nx > 0 && ny > 0 && nx <= x+d1 && ny >= y-d1) {
            arr[nx][ny] = 5;
            nx += 1;
            ny -= 1;
        }
        // .. 2
        nx = x;
        ny = y;
        while(nx > 0 && ny > 0 && nx <= x+d2 && ny <= y+d2) {
            arr[nx][ny] = 5;
            nx += 1;
            ny += 1;
        }
        // ... 3
        nx = x + d1;
        ny = y - d1;
        while(nx > 0 && ny > 0 && nx <= x+d1+d2 && ny <= y-d1+d2) {
            arr[nx][ny] = 5;
            nx += 1;
            ny += 1;
        }

        nx = x + d2;
        ny = y + d2;
        while(nx > 0 && ny > 0 && nx <= x+d2+d1 && ny >= y+d2-d1) {
            arr[nx][ny] = 5;
            nx += 1;
            ny -= 1;
        }
        dist(x, y, d1, d2);
    }

    public static void init() {
        for(int i = 0; i <= N; i++)
            for(int j = 0; j <= N; j++)
                arr[i][j] = 0;
    }

    public static void combXY() {  // 2) d1, d2에 따른 x, y값 구하기
        ArrayList<Integer> xx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            if((1 <= i) && (i < i+comb[1]+comb[2]) && (i+comb[1]+comb[2] <= N)) {
                xx.add(i);
            }
            if((1 <= i - comb[1]) && (i - comb[1] < i) && (i < i + comb[2]) && (i+comb[2] <= N)) {
                yy.add(i);
            }
        }

        for (Integer x : xx) {
            for (Integer y : yy) {
//                System.out.println(x + " " + y);
                init();
                solve(x, y, comb[1], comb[2]);
            }
        }
    }

    public static void combD(int cnt) {  // 1) d1, d2 조합 구하기
        if(cnt == 2) {
//            System.out.println(Arrays.toString(comb));
            combXY();
            return;
        }

        for(int i = 1; i < N-1; i++) {
            comb[cnt+1] = i;
            combD(cnt+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        arr = new int[N+1][N+1];
        count = new int[N+1];
        answer = 987654321;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb = new int[3]; // 1 : d1, 2 : d2
        combD( 0);
        System.out.println(answer);
    }
}
