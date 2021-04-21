import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15650_NM2 {
    public static int N, M;
    public static int[] arr;
    public static boolean[] vtd;

    public static void solve(int idx, int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                arr[cnt] = (i+1);
                solve(i, cnt+1);
                vtd[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        vtd = new boolean[N];

        solve(0, 0);
    }
}
