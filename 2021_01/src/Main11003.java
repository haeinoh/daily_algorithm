//https://www.acmicpc.net/problem/11003
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main11003 {
	public static int N, L, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 987654321;
		Deque<Integer> q = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < N; i++) {
	
			
			sb.append(min + " ");
		}
		System.out.println(sb.toString());
	}
}
