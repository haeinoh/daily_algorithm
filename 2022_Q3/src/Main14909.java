import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14909 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int cnt = 0;
        while(st.hasMoreTokens()) {
            if(Integer.parseInt(st.nextToken()) > 0) cnt++;
        }
        System.out.println(cnt);
    }
}
