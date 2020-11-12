//https://www.acmicpc.net/problem/11725
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11725 {
	public static Queue<Integer> q;
	public static LinkedList<Integer>list[];
	public static boolean vtd[];
	public static int arr[];

	public static void solve() {
		while(!q.isEmpty()) {
			int num = q.poll();
			vtd[num] = true;
			
			for(int i : list[num]) {
				if(!vtd[i]) {
					arr[i] = num;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new LinkedList[N+1];
		vtd = new boolean[N+1];
		arr = new int[N+1];
		q = new LinkedList<Integer>();
		
		for(int i = 0; i <= N; i++) list[i] = new LinkedList();
		
		for(int i = 0; i < N-1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		q.add(1);
		solve();
		
		for(int i = 2; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}
}
