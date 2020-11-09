//https://www.acmicpc.net/problem/117267
//top-down
import java.util.Scanner;

public class Main11726_1 {
	public static int N, dp[];
	
	public static int solve(int x) {
		if(x == 1) return 1;
		if(x == 2) return 2;
		
		if(dp[x] > 0) return dp[x];
		
		dp[x] = (solve(x-1) + solve(x-2))%10007;
		
		return dp[x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1];
		System.out.println(solve(N));
	}
}
