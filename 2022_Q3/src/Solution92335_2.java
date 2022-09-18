import java.util.Arrays;

public class Solution92335_2 {
    public static int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n, k).split("0");

        loop: for (String s : arr) {
            if (s.equals("") || s.equals("1")) continue;
            long value = Long.parseLong(s);

            for (int j = 2; j <= Math.sqrt(value); j++) {
                if (value % j == 0) continue loop;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }
}
