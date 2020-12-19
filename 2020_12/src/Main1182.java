//https://www.acmicpc.net/problem/1182
import java.util.Scanner;

public class Main1182 {
	public static int N, S, answer, arr[];
	
	public static void solve(int idx, int sum) {
		if(idx == N) return;
		if(sum+arr[idx] == S) answer++;
		
		solve(idx+1, sum); // 넘어가기
		solve(idx+1, sum+arr[idx]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		answer = 0;
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		solve(0, 0);
		System.out.println(answer);
	}
}
