import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1238 {
	public static int N, M, X, dist[], rdist[];
	public static List<List<Party>> list, rlist;
	
	static class Party implements Comparable<Party> {
		int v;
		int d;
		
		public Party(int v, int d) {
			this.v = v;
			this.d = d;
		}

		@Override
		public int compareTo(Party o) {
			return this.d - o.d;
		}
	}
	public static void solve(List<List<Party>> p, int di[]) {
		boolean vtd[] = new boolean[N+1];
		PriorityQueue<Party> pq = new PriorityQueue<>();
		di[X] = 0;
		pq.add(new Party(X, 0));
		
		while(!pq.isEmpty()) {
			int cur = pq.poll().v;
			
			if(vtd[cur]) continue; // 방문한적이 있다면 넘어가고 
			vtd[cur] = true;
			
			for(Party pa: p.get(cur)) { // cur와 연결된 간선들을 체크한다.
				if(di[pa.v] > di[cur] + pa.d) { // 그 간선의 현재 dist값보다, dist[cur] + 연결된 값이 더 작으면 교체한다.
					di[pa.v] = di[cur] + pa.d; 
					pq.add(new Party(pa.v, di[pa.v]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		rlist = new ArrayList<>();
		
		dist = new int[N+1]; // 집에서 파티를 참석하러 가는 경우
		rdist = new int[N+1]; // 파티에서 돌아오는 경우 (역방향) 모든 노드에서 X로 가는 것은 비효율적
		
		// 초기화 
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			rlist.add(new ArrayList<>());
			dist[i] = 987654321;
			rdist[i] = 987654321;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Party(b, c));
			rlist.get(b).add(new Party(a, c));
		}
		
		
		solve(list, dist);
		solve(rlist, rdist); 
		
		int answer = 0;
		for(int i = 1; i <= N; i++) 
			answer = Math.max(answer, (dist[i] + rdist[i]));
		
		System.out.println(answer);
	}
}
