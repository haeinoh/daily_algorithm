public class Solution12945_3 { // bottom-up
    static int[] dp;
    static int solve(int n) {
        if(dp[n] != 0) return dp[n];

        dp[n] = (solve(n-1)% 1234567) + (solve(n-2) % 1234567);
        return dp[n] % 1234567;
    }
    static int solution(int n) {
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return solve(n);
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }
}
