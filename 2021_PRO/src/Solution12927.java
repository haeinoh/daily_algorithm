import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution12927 {
    static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < works.length; i++) pq.add((long) works[i]);

        while(!pq.isEmpty()) {
            long val = pq.poll();
            if(val - 1 > 0) pq.add(--val);
            n--;
            if(n == 0) break;
        }

        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

//        return pq.stream().mapToLong(i -> i*i).sum();
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] w = {1, 3, 7};
        System.out.println(solution(n, w));
    }
}
