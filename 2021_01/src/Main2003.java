//https://www.acmicpc.net/problem/2003
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 		Main2003 {
	public static int N, M, arr[], answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while(start < N) {
			if(sum >=M) sum -= arr[start++]; // sum�� M���� Ŀ���� ��, ���ο� ���� ���� ���ְ�, start�� ��ĭ ������ �̵��Ѵ�. 
			else if(end == N) break;
			else sum += arr[end++]; //(sum�� M���� ���� ��) sum�� ���ο� ���� ���� ������ ��, end �����͸� �� ĭ �̵�
			
			if(sum == M) answer++; // sum�� M�� ���� ���� �� 
		}
		
		
		System.out.println(answer);
	}
}
