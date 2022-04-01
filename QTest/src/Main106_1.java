import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main106_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        StringBuilder sb  = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) sb.append(str.charAt(i));
        }

        System.out.println(sb.toString());
    }
}
