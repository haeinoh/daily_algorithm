import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        boolean[] vtd = new boolean[27];
        int count = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            Arrays.fill(vtd, false);
            boolean flag = false;
            int prev = str.charAt(0) - 'a';
            vtd[prev] = true;
            for(int j = 1; j < str.length(); j++) {
                int cur = str.charAt(j) - 'a';
                if(vtd[cur] && cur != prev) {
                    flag = true;
                    break;
                } else {
                    vtd[cur] = true;
                    prev = cur;
                }
            }
            if(!flag) count++;
        }
        System.out.println(count);
    }
}