import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(sc.nextInt());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int num = 1;
        int idx = 0;
        boolean flag = false;
        while(true) {
            if(idx == n) break;
            s.push(num);
            sb.append("+").append("\n");
            while(!s.isEmpty() && Objects.equals(list.get(idx), s.peek())) {
                s.pop();
                sb.append("-").append("\n");
                idx++;
            }
            if(num > n || idx > n) {
                flag = true;
                break;
            }
            num++;
        }

        if(flag) System.out.println("NO");
        else System.out.println(sb.toString());
    }
}
