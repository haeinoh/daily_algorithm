import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main505 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        String str = st.nextToken();

        Stack<Character> s = new Stack<>();
        int answer = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') s.push('(');
            else {
                s.pop();
                if(str.charAt(i-1) == '(') answer += s.size();
                else answer++;
            }
        }

        System.out.println(answer);
    }
}
