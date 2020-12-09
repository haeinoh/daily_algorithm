//https://www.acmicpc.net/problem/14501
import java.util.Arrays;
import java.util.Scanner;

public class Main14501 {
	public static int N, time[], price[], dp[];
	
	public static int solve(int day) {
		
		if(day >= N) return 0;
		
		if(dp[day] > 0) return dp[day];
		
		return dp[day] = Math.max(solve(day+1), solve(day+time[day])+price[day]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N];
		price = new int[N];
		dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			time[i] = x;
			price[i] = y;
		}
		System.out.println(solve(0));
	}
}
