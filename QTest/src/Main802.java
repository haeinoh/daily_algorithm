import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main802 {
    public static int C, N, answer;
    public static int[] arr;
    public static boolean[] vtd;
    public static void solve(int cnt, int sum, int idx) {
        if(sum > C) return;
        else answer = Math.max(answer, sum);

        for(int i = idx; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(cnt+1, sum+arr[i], i);
                vtd[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        vtd = new boolean[N];
        solve(0, 0, 0);
        System.out.println(answer);
    }
}
