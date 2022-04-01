import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main106 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        HashSet set = new HashSet();
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(!set.contains(ch)) {
                set.add(ch);
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}
