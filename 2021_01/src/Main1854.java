//https://www.acmicpc.net/problem/1854
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1854 {
	public static int N, M, K;
	public static List<List<Doro>> list;
	public static PriorityQueue<Doro> pq;
	public static PriorityQueue<Integer> dist[];
	
	static Comparator<Integer> com = new Comparator<Integer>() { // 내림차순으로 정렬 
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	};
	
	public static class Doro implements Comparable<Doro>{
		int node;
		int time;
		public Doro(int node, int time) {
			this.node = node;
			this.time = time;
		}
	
		@Override
		public int compareTo(Doro doro) {
			return this.time - doro.time;
		}
	}
	
	public static void solve() {
		PriorityQueue<Doro> pq = new PriorityQueue<>();
		dist[1].add(0); 
		pq.add(new Doro(1, 0));
		
		while(!pq.isEmpty()) {
			Doro tmp = pq.poll();
			int cur = tmp.node;
			int time = tmp.time;
			
			for(Doro d: list.get(cur)) {
				if(dist[d.node].size() < K) {
					dist[d.node].add((time + d.time));
					pq.add(new Doro(d.node, (time + d.time)));
				} else if(dist[d.node].peek() > time + d.time){ // K만큼만 체크하게 되면 가장 큰 값이 K번쨰 최단경로가 된다.
					dist[d.node].poll();
					dist[d.node].add(time + d.time);
					pq.add(new Doro(d.node, (time + d.time)));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		dist= new PriorityQueue[N+1]; 
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			dist[i] = new PriorityQueue<>(com);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Doro(b, c));
		}
		 

		solve();
		for(int i = 1; i <= N; i++) {
			if(dist[i].size() == K) System.out.println(dist[i].peek());
			else System.out.println("-1");
		}
	}
}
