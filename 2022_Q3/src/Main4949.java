import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main4949 {
    public static void main(String[] args)  throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        loop:while (true) {
            String ch = bf.readLine();
            if(ch.equals(".")) break loop;
            boolean flag = false;
            Stack<Character> s = new Stack<>();
            StringTokenizer st = new StringTokenizer(ch);
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == '[') s.push(str.charAt(i));
                    else if (str.charAt(i) == ')') {
                        if (s.isEmpty() || !(s.peek() == '(')) {
                            flag = true;
                        } else s.pop();
                    } else if (str.charAt(i) == ']') {
                        if (s.isEmpty() || !(s.peek() == '[')) {
                            flag = true;
                        } else s.pop();
                    }
                }
            }
            if(!s.isEmpty()) flag = true;
            if (!flag) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
