import java.util.Stack;

public class Solution42883_2 {
    static String solution(String number, int k) {
        int[] num = new int[number.length()];
        int len = number.length() - k;
        for(int i = 0; i < number.length(); i++) num[i] = Character.getNumericValue(number.charAt(i));

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int tmp : num) {
            while (!stack.isEmpty() && stack.peek() < tmp && k-- > 0) {
                stack.pop();
            }
            stack.push(tmp);
        }

        for(int i = 0; i < len; i++) sb.append(stack.get(i));

        return sb.toString();
    }

    public static void main(String[] args) {
        String n = "100";
        int nn = 1;
        System.out.println(solution(n, nn));
    }
}
