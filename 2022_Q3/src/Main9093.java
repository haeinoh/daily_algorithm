import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            StringBuilder answer = new StringBuilder();
            while(st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                answer.append(sb.reverse()).append(" ");
            }
            System.out.println(answer.toString());
        }
    }
}
