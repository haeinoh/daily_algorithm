import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        Queue<String> q = new LinkedList<>();
        q.offer(S);

        boolean flag = false;
        loop:while(!q.isEmpty()) {
            int size = q.size();
            int cnt = 0;
            while(size > 0) {
                String tmp = q.poll();
                String one = tmp + "A";
                String two = new StringBuilder(tmp).reverse().toString()+"B";
                if(tmp.equals(T)) {
                    flag = true;
                    break loop;
                }
                q.offer(one);
                q.offer(two);
                cnt = tmp.length();

                size--;
            }
            if(cnt == T.length()) break;
        }
        if(flag) System.out.println("1");
        else System.out.println("0");
    }
}
