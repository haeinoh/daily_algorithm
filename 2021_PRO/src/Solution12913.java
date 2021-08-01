public class Solution12913 {
    static int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        System.arraycopy(land[0], 0, dp[0], 0, land[0].length);

        for(int i = 1; i < land.length; i++) {
            dp[i][0] += land[i][0] + Math.max(dp[i-1][3], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] += land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][2] += land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
            dp[i][3] += land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }

        return Math.max(Math.max(dp[land.length-1][0], dp[land.length-1][1]), Math.max(dp[land.length-1][2], dp[land.length-1][3]));
    }

    public static void main(String[] args) {
        int[][] l = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        System.out.println(solution(l));
    }
}
