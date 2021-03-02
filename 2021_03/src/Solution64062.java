import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution64062 {
    static Comparator<Integer> comp = (o1, o2) -> o2 - o1;

    public static int solution(int[] stones, int k) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(comp);
        int start = 0;
        int end = 0;
        int count = 0;

        while(start <= end) {
            if(count >= k) {
                count--;
                q.remove(stones[start++]);
            } else if(end == stones.length) break;
            else {
                count++;
                q.add(stones[end++]);
            }

            if(count == k) {
                if(q.peek() <= k) answer = Math.max(answer, q.peek());
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] s = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        System.out.println(solution(s, k));
    }
}
