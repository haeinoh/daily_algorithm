import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main502 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        String str = st.nextToken();

        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        boolean flag = false;
        for(char x: str.toCharArray()) {
            if(x == '(') {
                flag = false;
                s.push('(');
            } else if(x == ')') {
                flag = true;
                s.pop();
            }

            if(flag && s.isEmpty() && ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z'))) {
                sb.append(x);
            }
        }
        System.out.println(sb.toString());
    }
}
