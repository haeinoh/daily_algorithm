import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main405 {
    public static int N, K;
    public static int[] arr;
    public static TreeSet<Integer> set;
    public static boolean[] vtd;
    public static void solve(int idx, int cnt, int sum) {
        if(cnt == 3) {
            set.add(sum);
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(i, cnt+1, sum + arr[i]);
                vtd[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        vtd = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        set = new TreeSet<>(Collections.reverseOrder());

        solve(0, 0, 0);

        List<Integer> list = new ArrayList<>(set);
        if(set.size() < K) System.out.println("-1");
        else System.out.println(list.get(K-1));

    }
}