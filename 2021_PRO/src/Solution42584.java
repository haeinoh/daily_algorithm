import java.util.Arrays;

public class Solution42584 {
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        answer[prices.length-1] = 0;
        for(int i = 0; i <= prices.length - 2; i++) {
            if(prices[i] < prices[prices.length-1]) answer[i] = prices.length - 1 - i;
            else {
                for(int j = i+1; j <= prices.length - 2; j++) {
                    if(prices[j] < prices[i] || prices[j] > prices[i]) {
                        answer[i] = (j-i);
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(p)));
    }
}
