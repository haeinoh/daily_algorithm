import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main15666_NM12 {
    public static int N, M;
    public static int[] arr, order;
    public static StringBuilder sb;

    public static void solve(int idx, int cnt) {
        if(cnt == M) {
            for(int val: order) sb.append(arr[val]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            order[cnt] = i;
            solve(i, cnt+1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));

        arr = new int[set.size()];
        order = new int[M];

        int idx = 0;
        for(Integer val:set) {
            arr[idx] = val;
            idx++;
        }

        Arrays.sort(arr);
        sb = new StringBuilder();
        solve(0, 0);

        System.out.println(sb.toString());
    }
}
