import java.util.Scanner;
import java.util.Stack;

public class Main17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            while (!s.isEmpty()) {
                if (s.peek() <= num) s.pop();
                else break;
            }
            s.push(num);
        }
        System.out.println(s.size());
    }
}