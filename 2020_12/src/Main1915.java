//https://www.acmicpc.net/problem/1915
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1915 {
	public static int N, M, answer, arr[][], dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		answer = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for(int j = 0; j < str.length(); j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				if(arr[i][j] == 1) {
					if(arr[i-1][j] == 1 && arr[i-1][j-1] == 1 && arr[i][j-1] == 1) {
						dp[i][j] = 1;
						dp[i][j] += Math.max(dp[i-1][j], Math.max(dp[i-1][j-1], dp[i][j-1]));
						
						if(dp[i][j] >= answer) answer = dp[i][j];
					} 
				}
			}
		}
		for(int i[]: dp)
			System.out.println(Arrays.toString(i));
		
		System.out.println(answer*answer);
	}
}
