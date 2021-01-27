//https://www.acmicpc.net/problem/1010
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1010 {
	public static int N, M;
	public static long dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int test = Integer.parseInt(st.nextToken());
		dp = new long [31][31];
		for(int i = 1; i <= 30; i++) dp[1][i] = i;
		for(int i = 2; i <= 30; i++) {
			for(int j = i; j <= 30; j++) {
				if(i == j) dp[i][j] = 1;
				else {
					for(int k = i-1; k < j; k++) {
						dp[i][j] += dp[i-1][k];
					}
				}
			}
		}
		for(int ts = 1; ts <= test; ts++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			System.out.println(dp[N][M]);
		}
	}
}
