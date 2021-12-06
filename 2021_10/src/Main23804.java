import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main23804 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N*5; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }

        for(int i = 0; i < N*5-N*2; i++) {
            for(int j = 0; j < N; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N*5; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
