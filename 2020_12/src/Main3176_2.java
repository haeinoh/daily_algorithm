import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main3176_2 {
	private static class Pair {
		int y;
		int num;
		public Pair(int y, int num) {
			this.y = y;
			this.num = num;
		}
	}
	public static int N, K, depth[], dp[][], maxDp[][], minDp[][], maxAns, minAns;
	public static List<List<Pair>> list;
	public static boolean vtd[];
	
	public static void dfs(int cur, int parent) {
		vtd[cur] = true;

		depth[cur] = depth[parent] + 1;

		for(Pair next: list.get(cur)) {
			int nx = next.y;
			int num = next.num;
			if(!vtd[nx]) {
				vtd[nx] = true;
				dp[nx][0] = cur;
				maxDp[nx][0] = num; //초기화
				minDp[nx][0] = num; 
				dfs(nx, cur);
			}
		}
	}
	
	public static void solve() {
		for(int i = 1; i <= 20; i++) {
			for(int j = 1; j <= N; j++) {
				dp[j][i] = dp[dp[j][i-1]][i-1];
				//maxDp[j][i]는 j노드의 2^i-1까지의 maxDp값과 그것의 조상 중 더 큰 값을 의미
				//minDp도
				maxDp[j][i] = Math.max(maxDp[j][i-1], maxDp[dp[j][i-1]][i-1]);
				minDp[j][i] = Math.min(minDp[j][i-1], minDp[dp[j][i-1]][i-1]);
			}
		}
	}
	
	public static void lca(int x, int y) {
		if(depth[x] < depth[y]) {
			int tmp = y;
			y = x;
			x = tmp;
		}
		
		for(int i = 20; i >= 0; i--) {
			if(depth[x] - depth[y] >= Math.pow(2, i)) {
				maxAns = Math.max(maxAns, maxDp[x][i]);
				minAns = Math.min(minAns, minDp[x][i]);
				x = dp[x][i];
			}
		}
		
		if(x != y) {
			for(int i = 20; i >= 0; i--) {
				if(dp[x][i] != dp[y][i]) {
					maxAns = Math.max(maxAns, Math.max(maxDp[x][i], maxDp[y][i]));
					minAns = Math.min(minAns, Math.min(minDp[x][i], minDp[y][i]));
					x = dp[x][i];
					y = dp[y][i];
				}
			}
			maxAns = Math.max(maxAns, Math.max(maxDp[x][0], maxDp[y][0]));
			minAns = Math.min(minAns, Math.min(minDp[x][0], minDp[y][0]));
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		depth = new int[N+1];
		dp = new int[N+1][21];
		maxDp = new int[N+1][21];
		minDp = new int[N+1][21];
		vtd = new boolean[N+1];
		
		list = new ArrayList<>();
		
//		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());		
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(!list.contains(a)) list.add(new ArrayList<>());
			list.get(a).add(new Pair(b, c));
			if(!list.contains(b)) list.add(new ArrayList<>());
			list.get(b).add(new Pair(a, c));
		}
		
		dfs(1, 0);
		solve();
		
		st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < K; i++) {
			maxAns = -987654321;
			minAns = 987654321;
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lca(x, y);
			System.out.println(minAns + " " + maxAns);
		}
	}
}
