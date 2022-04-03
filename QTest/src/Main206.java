import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main206 {
    public static boolean[] vtd;
    public static void init() {
        vtd[1] = true;
        vtd[2] = false;
        for(int i = 2; i <= Math.sqrt(100000); i++) {
            if(vtd[i]) continue;
            for(int j = i; (i*j) <= 100000; j++) {
                vtd[i*j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        vtd = new boolean[100001];
        init();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken()).reverse();
            int tmp = Integer.parseInt(sb.toString());
            if(!vtd[tmp]) ans.append(tmp).append(" ");
        }
        System.out.println(ans.toString());
    }
}
