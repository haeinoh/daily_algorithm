import java.util.LinkedList;
import java.util.Stack;

public class Solution76502 {
    static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) list.add(s.charAt(i));

        for(int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (Character character : list) {
                if (character == '[' || character == '(' || character == '{') {
                    stack.add(character);
                } else if (!stack.isEmpty()) {
                    if (character == ']' && stack.peek() == '[') stack.pop();
                    else if (character == ')' && stack.peek() == '(') stack.pop();
                    else if (character == '}' && stack.peek() == '{') stack.pop();
                    else {
                        flag = true;
                        break;
                    }
                } else {
                    flag = true;
                    break;
                }
            }
            list.addLast(list.removeFirst());
            if(!stack.isEmpty()) stack.clear();
            else if(!flag) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(solution(s));
    }
}
