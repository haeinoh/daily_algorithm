import java.util.Arrays;

public class Solution43238 {
    static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right = n * (long) times[times.length - 1];

        while(left <= right) {
            long mid = (left + right) >> 1;
            long cnt = 0;
            for (int time : times) {
                cnt += (mid / time);
            }

            if(cnt >= n) {
                right = mid - 1;
                answer = mid;
            }
            else left = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] t = {7, 10};
        System.out.println(solution(n, t));
    }
}
