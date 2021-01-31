//https://programmers.co.kr/learn/courses/30/lessons/72413
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution72413 {
	public static List<List<Taxi>> list;
	
	static class Taxi {
		int idx;
		int dist;

		public Taxi(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}
	
	public static void solve(int n, int s, int dist[]) {
		boolean vtd[] = new boolean[n+1];
		Queue<Taxi> q = new LinkedList<>();
		dist[s] = 0;
		q.add(new Taxi(s, 0));

		while(!q.isEmpty()) {
			Taxi tmp = q.poll();
			int cur = tmp.idx;

			if(vtd[cur]) continue;
			vtd[cur] = true;
			
			for(Taxi t: list.get(cur)) {
				if(dist[t.idx] > dist[cur] + t.dist) {
					dist[t.idx] = dist[cur] + t.dist; 
					q.add(new Taxi(t.idx, dist[t.idx]));
				}
			}
		}
	}
	
	public static void init(int n, int dist[] ) {
		for(int i = 0; i <= n; i++) dist[i] = 987654321;
	}
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        list = new ArrayList<>();
        int dist[] = new int[n+1];
        int dist2[] = new int[n+1];
        
        init(n, dist);
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
        
        for(int i = 0; i < fares.length; i++) {
        	list.get(fares[i][0]).add(new Taxi(fares[i][1], fares[i][2]));
        	list.get(fares[i][1]).add(new Taxi(fares[i][0], fares[i][2]));
        }
        
        solve(n, s, dist);
        System.out.println(Arrays.toString(dist));
        answer = dist[a] + dist[b];
        for(int i = 1; i <= n; i++) {
        	if(dist[i] != 987654321) {
        		init(n, dist2);
        		solve(n, i, dist2);
        		System.out.println("answer : " + answer);
        		System.out.println("------------------ " + i);
        		System.out.println(Arrays.toString(dist2));
        		answer = Math.min(answer, (dist[i] + dist2[a] + dist2[b]));
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
//		int n = 6;
//		int s = 4;
//		int a = 6;
//		int b = 2;
//		int fares[][] = {
//			{4, 1, 10}, 
//			{3, 5, 24}, 
//			{5, 6, 2}, 
//			{3, 1, 41}, 
//			{5, 1, 24}, 
//			{4, 6, 50},
//			{2, 4, 66}, 
//			{2, 3, 22}, 
//			{1, 6, 25}
//		};
		
		int n = 6;
		int s = 4;
		int a = 5;
		int b = 6;
//		int fares[][] = {
//			{5, 7, 9},
//			{4, 6, 4}, 
//			{3, 6, 1}, 
//			{3, 2, 3},
//			{2, 1, 6}
//		};
		
		int fares[][] = {
			{2,6,6}, 
			{6,3,7}, 
			{4,6,7}, 
			{6,5,11}, 
			{2,5,12}, 
			{5,3,20}, 
			{2,4,8}, 
			{4,3,9}
		};
		
		
		System.out.println(solution(n, s, a, b, fares));
	}
}
