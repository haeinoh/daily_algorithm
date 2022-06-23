import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < K; i++) q.offer(i+1);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()) {
            int size = N-1;
            while(size > 0) {
                int num = q.poll();
                q.offer(num);
                size--;
            }
            if(q.size() == 1) sb.append(q.poll());
            else sb.append(q.poll()).append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
