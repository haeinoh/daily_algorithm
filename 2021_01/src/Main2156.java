//https://www.acmicpc.net/problem/2156
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2156 {
	public static int N, arr[], dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i-1] : 현재 선택 x, 그 전 선택 o, 그 전전 선택 o
		// arr[i] + arr[i-1] + dp[i-3] : 현재 선택 o, 그 전 선택 o, 그 전전 선택 x, 그 전전전 선택 o
		// arr[i] + dp[i-2] : 현재 선택 o, 그 전 선택 x, 그 전전 선택 o
		if(N >= 1) dp[0] = arr[0];
		if(N >= 2) dp[1] = arr[1] + arr[0];
		if(N >= 3) dp[2] = Math.max(dp[1], Math.max(arr[2] + arr[1], arr[2] + arr[0])); //i-3때문에 미리처리

		for(int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]));
		}
		System.out.println(dp[N-1]); 
	}
}
