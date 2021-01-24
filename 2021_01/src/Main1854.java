//https://www.acmicpc.net/problem/1854
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1854 {
	public static int N, M, K, arr[][];
	public static PriorityQueue<Doro> pq;
	public static PriorityQueue<Integer> dist[];
	
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
//		for(int i = 1; i <= N; i++) {
//			dist[i].add(arr[1][i]);
//		}
		dist[1].add(0);
		pq.add(new Doro(1, 0));
		
		while(!pq.isEmpty()) {
			Doro tmp = pq.poll();
			int cur = tmp.node;
			int time = tmp.time;
			
			for(int i = 1; i <= N; i++) {
				if(arr[cur][i] > 0) {
					System.out.println(i + " " + dist[i].size() + " ::  " + (time+arr[cur][i]) + "  " + dist[i].peek());
					
					if(dist[i].size() < K) { //K개이하
						dist[i].add(time+arr[cur][i]);
						pq.add(new Doro(i, time+arr[cur][i]));
					} else if(time + arr[cur][i] < dist[i].peek()){
						System.out.println(" ????????? " + dist[i].peek());
						dist[i].poll();
						dist[i].add(time+arr[cur][i]);
						pq.add(new Doro(i, time + arr[cur][i]));
					}
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
		arr = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = c;
		}
		dist = new PriorityQueue[N+1]; // ??? 어떻게 정렬해여??
		for(int i = 1; i <= N; i++) dist[i] = new PriorityQueue<>(i);
		pq = new PriorityQueue<>();

		solve();
		for(int i = 1; i <= N; i++) {
			if(dist[i].size() == K) System.out.println(dist[i].peek());
			else System.out.println("-1");
		}
	}
}
