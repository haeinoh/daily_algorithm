//https://www.acmicpc.net/problem/14728
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14728 {
	public static int N, T, time[], points[] , dp[][];
	
	public static void solve() {
		for(int i = 1; i <= N; i++) {
			for(int p = 0; p <= T; p++) {
				if(p - time[i] < 0) dp[i][p] = dp[i-1][p];
				else dp[i][p] = Math.max(dp[i-1][p], dp[i-1][p-time[i]] + points[i]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		time = new int[N+1];
		points = new int[N+1];
		dp = new int[N+1][T+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			points[i] = Integer.parseInt(st.nextToken());
		}
		solve();
		System.out.println(dp[N][T]);
	}
}
