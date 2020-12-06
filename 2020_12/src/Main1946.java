//https://www.acmicpc.net/problem/1946
import java.util.Scanner;

public class Main1946 {
	public static int answer, N, arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int ts = 1; ts <= test; ts++) {
			answer = 0;
			N = sc.nextInt();
			arr = new int[N+1];
			for(int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a] = b;
			}
			int num = 987654321;
			for(int i = 1; i <= N; i++) {
				if(num > arr[i]) {
					num = arr[i];
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
