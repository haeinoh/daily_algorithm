import java.util.PriorityQueue;

public class Solution42626 {
    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : scoville) pq.offer(j);

        while(pq.size() > 0) {
            int one = pq.poll();
            if(one >= K) break;
            if(pq.size() == 0) return -1;
            int two = pq.poll();
            int tmp = one + two * 2;
            pq.offer(tmp);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] s = {1, 2, 3, 9, 10, 12};
        int[] s = {1, 1};
        int k = 7;
        System.out.println(solution(s, k));
    }
}
