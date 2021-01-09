//https://www.acmicpc.net/problem/10844
import java.util.Scanner;

public class Main10844 {
	public static int N, dp[][];
	public static void solve() {
		for(int i = 1; i <= 9; i++) dp[1][i] = 1;
		
		for(int i = 2; i <= 100; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % 1000000000;
			}
			dp[i][9] = dp[i-1][8] % 1000000000;
		} 
	}
	
	public static void main(String[] args) {
		dp = new int[101][10];
		solve();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long sum = 0;
		for(int i = 0; i <= 9; i++) sum += dp[N][i];
		System.out.println(sum % 1000000000);
	}
}
