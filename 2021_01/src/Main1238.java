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
			
			if(vtd[cur]) continue; // �湮������ �ִٸ� �Ѿ�� 
			vtd[cur] = true;
			
			for(Party pa: p.get(cur)) { // cur�� ����� �������� üũ�Ѵ�.
				if(di[pa.v] > di[cur] + pa.d) { // �� ������ ���� dist������, dist[cur] + ����� ���� �� ������ ��ü�Ѵ�.
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
		
		dist = new int[N+1]; // ������ ��Ƽ�� �����Ϸ� ���� ���
		rdist = new int[N+1]; // ��Ƽ���� ���ƿ��� ��� (������) ��� ��忡�� X�� ���� ���� ��ȿ����
		
		// �ʱ�ȭ 
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
