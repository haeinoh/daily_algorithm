//https://programmers.co.kr/learn/courses/30/lessons/64062
import java.util.Arrays;

public class Solution64062 {
    public static boolean check(int mid, int[] stones, int k) {
        int count = 0;
        for (int stone : stones) {
            if (stone - mid < 0) count++;
            else count = 0;

            if (count == k) return false;
        }
        return true;
    }
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int start = Arrays.stream(stones).min().getAsInt();
        int end = Arrays.stream(stones).max().getAsInt();

        if(start == end) return end;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(check(mid, stones, k)) {
                start = mid + 1;
                answer = mid;
            } else end = mid - 1;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] s = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        System.out.println(solution(s, k));
    }
}
