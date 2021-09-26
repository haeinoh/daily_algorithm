import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2075 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) pq.add(Integer.parseInt(st.nextToken()));

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(pq.peek() < num) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        System.out.println(pq.poll());
    }
}
