import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main105 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        String rev = "";
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) rev += str.charAt(i);
        }
        int idx = rev.length() - 1;
        for(int i = 0; i < str.length(); i++) {
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                answer += rev.charAt(idx);
                idx--;
            }
            else answer += str.charAt(i);
        }
        System.out.println(answer);
    }
}
