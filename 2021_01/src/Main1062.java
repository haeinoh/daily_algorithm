import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1062 {
    public static int N, K, answer;
    public static String arr[];
    public static char alpha[] = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q'
            ,'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static boolean vtd[];

    public static int check() {
        int ans = 0;

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < arr[i].length(); j++) {
                int idx = arr[i].charAt(j) - 'a';
                if(vtd[idx]) cnt++;
            }
            if(cnt == arr[i].length()) ans++;
        }
        return ans;
    }

    public static void solve(int idx, int cnt) {
        if(cnt == K-5) {
            answer = Math.max(answer, check());
            return;
        }

        for(int i = idx; i < alpha.length; i++) {
            int k = alpha[i] - 'a';
            if(!vtd[k]) {
                vtd[k] = true;
                solve(i, cnt+1);
                vtd[k] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new String[N];
        vtd = new boolean[27];
        answer = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            String str = st.nextToken();
            arr[i] = str.substring(4, str.length()-4);
        }

        if(K >= 5) {
            vtd['a'-'a'] = true;
            vtd['c'-'a'] = true;
            vtd['n'-'a'] = true;
            vtd['i'-'a'] = true;
            vtd['t'-'a'] = true;
            solve(0, 0);
        } else answer = 0;
        System.out.println(answer);
    }
}
