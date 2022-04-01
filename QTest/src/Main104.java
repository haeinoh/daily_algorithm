import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main104 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            StringBuilder str = new StringBuilder(st.nextToken());
            answer.append(str.reverse()).append("\n");
        }
        System.out.println(answer.toString());
    }
}
