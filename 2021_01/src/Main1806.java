///https://www.acmicpc.net/problem/1806
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806 {
	public static int N, S, arr[], answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		answer = 987654321;
		int start = 0;
		int end = 0;
		int sum = 0;

		while(start < N) {
			 if(sum >= S) {
				if(answer >= (end-start)) {
					answer = end-start;
				}
				sum -= arr[start++];
			}else if(end == N) break; 
			 else sum += arr[end++];
		}
		if(answer == 987654321) answer = 0;
		System.out.println(answer);
	}
}
