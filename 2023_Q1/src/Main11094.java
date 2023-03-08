import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11094 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String str = bf.readLine();
            if(str.contains("Simon says")) {
                sb.append(" ").append(str.split("Simon says ")[1]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
