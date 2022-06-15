public class Solution12902 {
    public static int solution(int n) {
        int[] dp = new int[n+1];
        dp[2] = 3;
        dp[4] = 11;
        if(n % 2 == 1) return 0 % 1000000007;
        else if(n == 2 || n == 4) return dp[n];
        for(int i = 6; i <= n; i+=2) dp[i] = (((dp[i-2]%1000000007)*4)%1000000007 - (dp[i-4]%1000000007))%1000000007;
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
}
