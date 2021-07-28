import java.util.Arrays;

public class Solution42584 {
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < answer.length; i++) {
            for(int j = i+1; j < answer.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(p)));
    }
}
