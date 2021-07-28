import java.util.Stack;

public class Solution12973 {
    static int solution(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            String val = String.valueOf(s.charAt(i));
            if(!stack.isEmpty()) {
                String tmp = stack.peek();
                if(tmp.equals(val)) stack.pop();
                else stack.push(val);
            } else stack.push(val);
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }
}
