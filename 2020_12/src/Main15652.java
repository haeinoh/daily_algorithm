//https://www.acmicpc.net/problem/15652
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15652 {
	public static int N, M;
	
	public static void solve(int idx, int cnt, String sb) {
		if(cnt == M) {
			System.out.println(sb.toString());
			return;
		}
		
		for(int i = idx; i < N; i++) {
			solve(i, cnt+1, sb + (i+1) + " ");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		solve(0, 0, "");
	}
}
