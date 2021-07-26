import java.util.Stack;

public class Solution12909 {
    static boolean solution(String s) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(left < right) return false;
            if(s.charAt(i) == '(') left++;
            else right++;
        }
        return left == right;
    }
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));
    }
}