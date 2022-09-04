import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2954 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                    i+=2;
                    sb.append(str.charAt(i));
                } else sb.append(str.charAt(i));
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
