import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main504 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        String str = st.nextToken();

        Stack<Integer> s = new Stack<>();

        for(char x : str.toCharArray()) {
            if(!s.isEmpty() && !Character.isDigit(x)) {
                int val2 = s.pop();
                int val1 = s.pop();
                switch (x) {
                    case '+' :
                        s.push(val1 + val2);
                        break;
                    case '-' :
                        s.push(val1 - val2);
                        break;
                    case '*' :
                        s.push(val1 * val2);
                        break;
                    case '/' :
                        s.push(val1 / val2);
                        break;
                }
            } else s.push(x -'0');
        }

        System.out.println(s.pop());
    }
}
