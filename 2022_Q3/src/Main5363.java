import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5363 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String[] str = bf.readLine().split(" ");
            StringBuilder sb = new StringBuilder();

            for(int k = 2; k < str.length; k++) sb.append(str[k]).append(" ");
            sb.append(str[0]).append(" ").append(str[1]);
            System.out.println(sb.toString());
        }
    }
}
