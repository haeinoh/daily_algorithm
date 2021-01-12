//https://www.acmicpc.net/problem/2252
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2252 {
	public static int N, M, arr[];
	public static List<List<Integer>> list;
	public static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		list = new ArrayList<>();
		q = new LinkedList<>();
		
		for(int i = 1; i <= N+1; i++) list.add(new ArrayList<>());
	
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y); // x -> y
			arr[y]++; // count 진입 차수
		}
		
		for(int i = 1; i <= N; i++) { // 진입 차수가 0이면 queue에 넣는다 
			if(arr[i] == 0) { // 진입 차수가 0이라는 의미이다.
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) { // 학생 수를 다 돌아본다.
			if(q.isEmpty()) { // 사이클이 발생하는 경우
				break;
			}
			
			int zero = q.poll();
			sb.append(zero + " "); // 큐에서 제거 후 순서에 저장 
			
			for(int k = 0; k < list.get(zero).size(); k++) {   
				int num = list.get(zero).get(k); // 연결된 정점들 중에서
				if(--arr[num] == 0) { // 간선을 제거하고 진입차수가 0이된 정점을 
					q.add(num); // 큐에 넣어준다.
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
