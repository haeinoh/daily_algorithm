import java.util.Scanner;
import java.util.Stack;

public class Main1918 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> s = new Stack<>();

        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if(tmp >= 'A' && tmp <= 'Z') {
                answer += tmp;
            } else {
                if(tmp == ')') {
                    answer += s.pop();
                } else if(tmp == '(') {

                } else {
                    s.push(tmp);
                }
            }

        }


        System.out.println(answer);
    }
}
