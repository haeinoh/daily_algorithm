import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main207 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        int prev = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp ==1) {
                prev++;
                answer += prev;
            } else {
                prev = 0;
            }
        }
        System.out.println(answer);
    }
}
