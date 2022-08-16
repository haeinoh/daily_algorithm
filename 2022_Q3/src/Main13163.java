import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13163 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String[] str = bf.readLine().split(" ");
            sb.append("god");
            for(int j = 1; j < str.length; j++) sb.append(str[j]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
