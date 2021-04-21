import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15655_NM6 {
    public static int N, M;
    public static int[] arr, order;
    public static boolean[] vtd;
    public static StringBuilder sb;
    public static void solve(int idx, int cnt) {
        if(cnt == M) {
            for(int value: order) sb.append(arr[value]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                order[cnt] = i;
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

        arr = new int[N];
        order = new int[M];
        vtd = new boolean[N];
        sb = new StringBuilder();

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        solve(0, 0);

        System.out.println(sb.toString());
    }
}
