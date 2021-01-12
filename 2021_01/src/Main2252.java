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
			arr[y]++; // count ���� ����
		}
		
		for(int i = 1; i <= N; i++) { // ���� ������ 0�̸� queue�� �ִ´� 
			if(arr[i] == 0) { // ���� ������ 0�̶�� �ǹ��̴�.
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) { // �л� ���� �� ���ƺ���.
			if(q.isEmpty()) { // ����Ŭ�� �߻��ϴ� ���
				break;
			}
			
			int zero = q.poll();
			sb.append(zero + " "); // ť���� ���� �� ������ ���� 
			
			for(int k = 0; k < list.get(zero).size(); k++) {   
				int num = list.get(zero).get(k); // ����� ������ �߿���
				if(--arr[num] == 0) { // ������ �����ϰ� ���������� 0�̵� ������ 
					q.add(num); // ť�� �־��ش�.
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
