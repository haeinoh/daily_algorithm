//https://www.acmicpc.net/problem/3176
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	int y;
	int num;
	public Pair(int y, int num) {
		this.y = y;
		this.num = num;
	}
}

public class Main3176 {
	public static int N, K, depth[], dp[][], maxDp[][], minDp[][], maxAns, minAns;
	public static List<List<Pair>> list;
	public static boolean vtd[];
	
	public static void dfs(int cur, int parent) {
		vtd[cur] = true;

		depth[cur] = depth[parent] + 1;

		for(Pair next: list.get(cur)) {
			if(!vtd[next.y]) {
				vtd[next.y] = true;
				dp[next.y][0] = cur;
				maxDp[next.y][0] = next.num; //초기화
				minDp[next.y][0] = next.num; 
				dfs(next.y, cur);
			}
		}
	}
	
	public static void solve() {
		for(int i = 1; i <= 20; i++) {
			for(int j = 1; j <= N; j++) {
				dp[j][i] = dp[dp[j][i-1]][i-1];
				//maxDp[j][i]는 j노드의 2^i-1까지의 maxDp값과 그것의 조상 중 더 큰 값을 의미한다.
				//minDp도 마찬가지이다.
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
			if(depth[x] - depth[y] >= (1 << i)) { //???????????????????
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
		
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Pair(b, c));
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
