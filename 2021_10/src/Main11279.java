import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int val = Integer.parseInt(st.nextToken());
            if(val == 0) {
                if(!pq.isEmpty()) System.out.println(-1*pq.poll());
                else System.out.println("0");
            } else pq.add(-1*val);
        }
    }
}
