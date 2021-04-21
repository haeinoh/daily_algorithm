import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main15664_NM10 {
    public static int N, M;
    public static int[] arr;
    public static boolean[] vtd;
    public static ArrayList<String> list;
    public static HashSet<String> set;

    public static void solve(int idx, int cnt, String str) {
        if(cnt == M) {
            if(!set.contains(str)) {
                set.add(str);
                list.add(str);
            }
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(i, cnt+1, (str + arr[i] + " "));
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
        solve(0, 0, "");

        StringBuilder sb = new StringBuilder();
        for(String val: list) sb.append(val).append("\n");

        System.out.println(sb.toString());
    }
}
