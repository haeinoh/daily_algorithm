import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) q.offer(i);
        sb.append("<");
        while(!q.isEmpty()) {
            int size = K-1;
            while(size > 0) {
                int tmp = q.poll();
                q.offer(tmp);
                size--;
            }
            sb.append(q.poll());
            if(q.size() > 0) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
