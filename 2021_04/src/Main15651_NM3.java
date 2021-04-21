import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15651_NM3 {
    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb;

    public static void solve(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[cnt] = (i+1);
            solve(cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        arr = new int[M];

        solve(0);
        System.out.println(sb.toString());
    }
}
