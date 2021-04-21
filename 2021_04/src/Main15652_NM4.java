import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15652_NM4 {
    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb;
    public static void solve(int idx, int cnt) {
        if(cnt == M) {
            for(int i: arr) sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for(int i = idx; i < N; i++) {
            arr[cnt] = (i+1);
            solve(i, cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        sb = new StringBuilder();
        solve(0, 0);
        System.out.println(sb.toString());
    }
}
