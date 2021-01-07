//https://www.acmicpc.net/problem/12865
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865 {
	public static int N, K, arr[][], dp[][];
	public static void solve() {
		for(int i = 1; i <= N; i++) { // index
			for(int w = 0; w <= K; w++) { // weight
				if(w-arr[i][0] < 0) dp[i][w] = dp[i-1][w]; // 배낭에 물건을 채울 수 없는경우, 그 전까지의 최대값 가져온다.
				else dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-arr[i][0]] + arr[i][1]);
				// 이번 물건을 채우지 않는 경우 , 이번 물건을 넣어가는 경우(그 전까지 + 해당 차례 가치_
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][2];
		dp = new int[N+1][K+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // weight
			arr[i][1] = Integer.parseInt(st.nextToken()); // value
		}
		
		solve();
		System.out.println(dp[N][K]);
	}
}
