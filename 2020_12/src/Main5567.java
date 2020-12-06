//https://www.acmicpc.net/problem/5567
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main5567 {
	public static int N, M, answer;
	public static List<List<Integer>> list;
	public static Queue<Integer> q;
	public static boolean vtd[];
	
	public static void solve() {
		int time = 0;
		loop:while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				int x = q.poll();
				
				for(int i : list.get(x)) {
					if(!vtd[i]) {
						q.add(i);
						vtd[i] = true;
						answer++;
					}
				}
				size--;
			}
			time++;
			if(time == 2) break loop;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		list = new ArrayList<>();
		q = new LinkedList<Integer>();
		vtd = new boolean[N+1];
		
		answer = 0;
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		vtd[1] = true;
		q.add(1);
		solve();
		
		System.out.println(answer);
		
	}
}
