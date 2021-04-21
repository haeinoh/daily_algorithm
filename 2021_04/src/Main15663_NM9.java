import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main15663_NM9 {
    public static int N, M;
    public static int[] arr;
    public static boolean[] vtd;
    public static HashSet<String> set;
    public static List<String> list;

    public static void solve(int cnt, String str) {
        if(cnt == M) {
            if(!set.contains(str)) {
                set.add(str);
                list.add(str);
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(cnt+1, (str + (arr[i])+ " "));
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
        vtd = new boolean[N];
        list = new ArrayList<>();
        set = new HashSet<>();

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        solve( 0, "");

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}
