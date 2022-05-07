import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        String str = st.nextToken();

        Stack<Character> s = new Stack<>();
        for(char x: str.toCharArray()) {
            s.add(x);
        }

        Stack<Character> tmp = new Stack<>();
        int cnt = 0;
        boolean answer = true;
        while(!s.isEmpty()) {
           if(s.peek() == ')') {
               tmp.push(s.pop());
           } else {
               if(tmp.size() == 0) {
                   answer = false;
                   break;
               }
               s.pop();
               tmp.pop();
           }
        }
        if(tmp.size() != 0 || !answer) System.out.println("NO");
        else System.out.println("YES");
    }
}
