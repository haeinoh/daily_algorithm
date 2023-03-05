import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2703 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String str = bf.readLine();
            String[] val = bf.readLine().split("");

            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ' ') sb.append(" ");
                else sb.append(val[(str.charAt(j) - '0' - 17)]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
