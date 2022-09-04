import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2711 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int index = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            sb.append(str.substring(0, index-1)).append(str.substring(index, str.length())).append("\n");
        }
        System.out.println(sb.toString());
    }
}
