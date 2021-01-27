import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1238 {
	public static int N, M, X, arr[][], rarr[][], dist[], rdist[];
	
	public static void solve(int sol[][]) {
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		rarr = new int[N+1][N+1];
		
		dist = new int[N+1];
		rdist = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			dist[i] = 987654321;
			rdist[i] = 987654321;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = c;
			rarr[b][a] = c;
		}
		
		solve(arr);
		solve(rarr);
		int answer = 0;
		for(int i = 1; i <= N; i++) 
			answer = Math.max(answer, (dist[i] + rdist[i]));
		
		System.out.println(answer);
	}
}
