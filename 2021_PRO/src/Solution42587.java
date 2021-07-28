import java.util.Collections;
import java.util.PriorityQueue;

public class Solution42587 {
    static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int p: priorities) pq.offer(p);

        loop:while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if(i == location) {
                        break loop;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] p = {1, 1, 9, 1, 1, 1};
        int loc = 0;
        System.out.println(solution(p, loc));
    }
}
