import java.util.Arrays;

public class Solution43105 {
    static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 0; i < triangle.length - 1; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                dp[i+1][j] = Math.max(triangle[i+1][j] + dp[i][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(triangle[i+1][j+1] + dp[i][j], dp[i+1][j+1]);
            }
        }

        for(int i = 0; i < dp[dp.length-1].length; i++) answer = Math.max(answer, dp[dp.length-1][i]);
//        answer = Arrays.stream(dp[dp.length-1]).max().getAsInt();
        return answer;
    }

    public static void main(String[] args) {
        int[][] t = {
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        };
        System.out.println(solution(t));
    }
}
