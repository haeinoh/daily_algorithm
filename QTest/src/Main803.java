import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main803 {
    public static int N, M, answer;
    public static int[][] arr;
    public static boolean[] vtd;

    public static void solve(int idx, int cnt, int time, int sum) {
        if(time <= M) answer = Math.max(answer, sum);

        if(cnt == N) return;

        for(int i = idx; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(i, cnt+1, time+arr[i][1], sum+arr[i][0]);
                vtd[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        vtd = new boolean[N];
        answer = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0, 0, 0);
        System.out.println(answer);
    }
}
