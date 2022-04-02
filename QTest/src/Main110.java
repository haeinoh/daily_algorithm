import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        String target = st.nextToken();
        int idx = 0;
        int prev = 0;
        for(int i = 0; i < str.length(); i++) {
            int tmp = str.indexOf(target, idx);
            int pr = str.indexOf(target, prev);
            System.out.print(Math.abs(Math.min(Math.abs(tmp - i), Math.abs(pr - i))) + " ");
            if(i == str.indexOf(target, idx)) {
                prev = i;
                idx = i+1;
            }
        }
    }
}
