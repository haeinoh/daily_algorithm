import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main103 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = 0;
        String ansStr = "";
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if(answer < str.length()) {
                answer = str.length();
                ansStr = str;
            }
        }
        System.out.println(ansStr);
    }
}
