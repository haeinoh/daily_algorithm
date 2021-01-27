//https://www.acmicpc.net/problem/1766
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1766 {
	public static List<List<Integer>> list;
	public static int N, M, arr[];
	public static PriorityQueue<Integer> q;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		q = new PriorityQueue<>();
		arr = new int[N+1];
		sb = new StringBuilder();
		
		for(int i = 1; i <= N+1; i++) list.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			arr[b]++;
		}
		
		for(int i = 1; i <= N; i++) {
			if(arr[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp + " ");
			
			for(int i = 0; i < list.get(tmp).size(); i++) {
				int num = list.get(tmp).get(i);
				if(--arr[num] == 0) q.add(num);
			}
		}
		
		System.out.println(sb.toString());
	}
}