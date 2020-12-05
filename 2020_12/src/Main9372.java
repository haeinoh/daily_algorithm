//https://www.acmicpc.net/problem/9372
import java.util.Scanner;

public class Main9372 {
	public static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int ts = 1; ts <= test; ts++) {
			N = sc.nextInt();
			M = sc.nextInt();
			for(int i = 0; i < M; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
			}
			System.out.println(N-1);
		}
	}
}
