import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution118667 {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long value = (sum1 + sum2) / 2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) q1.add(queue1[i]);
        for(int i = 0; i < queue2.length; i++) q2.add(queue2[i]);

        boolean flag = false;
        while(answer <= (queue1.length + queue2.length) + Math.max(queue1.length, queue2.length)) {
            if(sum1 == sum2) {
                flag = true;
                break;
            }
            if(sum1 > value && !q1.isEmpty()) {
                int valueQ1 = q1.poll();
                q2.add(valueQ1);
                sum1 -= valueQ1;
                sum2 += valueQ1;
            } else if (sum2 > value && !q2.isEmpty()){
                int valueQ2 = q2.poll();
                q1.add(valueQ2);
                sum2 -= valueQ2;
                sum1 += valueQ2;
            }
            answer++;
        }

        if(!flag) return -1;
        return answer;
    }

    public static void main(String[] args) {
        int[] q1 = {1, 1, 1, 1, 1};
        int[] q2 = {1, 1, 1, 9, 1};
        System.out.println(solution(q1, q2));
    }
}
