//https://www.acmicpc.net/problem/4811
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4811 {
	public static long dp[][];

	public static long init(int w, int h) {
		if(dp[w][h] > 0) return dp[w][h]; // 이미 계산한 적이 있다면

		if(w == 0) return 1; // 한 조각이 아예 없는 경우
		
		if(h == 0) return dp[w][h] = init(w-1, h+1); // 반 조각이 없는 경우, (한 조각은 있는 경우)
		else return dp[w][h] = init(w, h-1) + init(w-1, h+1); // 반 조각도 있고(w, h-1) 한 조각도 있는 경우(w-1, h+1)
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		dp = new long[31][31];
		init(30, 0);
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine().trim());
			int test = Integer.parseInt(st.nextToken());
			if(test == 0) break;
			System.out.println(dp[test][0]);
		}
	}
}
