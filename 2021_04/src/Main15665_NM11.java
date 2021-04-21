import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main15665_NM11 {
    public static int N, M;
    public static int[] arr, order;
    public static StringBuilder sb;

    public static void solve(int cnt) {
        if(cnt == M) {
            for(Integer val: order) sb.append(arr[val]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            order[cnt] = i;
            solve(cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        order = new int[M];
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        arr = new int[set.size()];
        int idx = 0;
        for(Integer val: set) {
            arr[idx] = val;
            idx++;
        }

        Arrays.sort(arr);
        sb = new StringBuilder();

        solve(0);

        System.out.println(sb.toString());
    }
}
