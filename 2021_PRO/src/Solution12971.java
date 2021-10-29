import java.util.Arrays;

public class Solution12971 {
    public static int solution(int sticker[]) {
        int[][] dp = new int[sticker.length][2];

        dp[0][0] = 0; // 0 : 첫번째 스티커를 뜯지 않는 경우
        dp[0][1] = sticker[0]; // 1 : 첫번째 스티커를 뜯는 경우

        if(sticker.length >= 2) {
            dp[1][0] = sticker[1];
            dp[1][1] = dp[0][1];
        }
        for(int i = 2; i < sticker.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0] + sticker[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1] + sticker[i]);
        }

        return Math.max(dp[sticker.length-1][0], dp[sticker.length-2][1]);
    }

    public static void main(String[] args){
        int[] s = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(solution(s));
    }
}
