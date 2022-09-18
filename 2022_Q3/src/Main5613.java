import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main5613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        Queue<String> q = new LinkedList<>();

        for(int i = 0; ; i++) {
            String str = sc.next();
            if(str.equals("=")) break;
            q.add(str);
            if(q.size() == 3) {
                int a = Integer.parseInt(q.poll());
                String s = q.poll();
                int b = Integer.parseInt(q.poll());
                switch (s) {
                    case "+": a += b; break;
                    case "-": a -= b; break;
                    case "/": a /= b; break;
                    case "*": a *= b; break;
                }
                q.add(String.valueOf(a));
            }
        }

        System.out.println(q.poll());
    }
}
