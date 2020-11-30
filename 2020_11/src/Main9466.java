//https://www.acmicpc.net/problem/9466
import java.util.Scanner;

public class Main9466 {
	public static int answer, N, arr[][];
	public static boolean vtd[];
	
	public static void solve(int start, int prev, int cur, int sum) {
		if(start == prev) {
			answer += sum;
			System.out.println("? " + sum + " ------- " + answer);
//			return;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println("¿¨ " + start + "//// " +prev + " " +i);
			if(!vtd[i] && arr[prev][i] == 1) {
				vtd[i] = true;
				System.out.println("inside: " + " " + i);
				solve(start, i, -1, ++sum);
				vtd[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int ts = 1; ts <= test; ts++) {
			N = sc.nextInt();
			arr = new int[N][N];
			vtd = new boolean[N];
			answer = 0;
			for(int i = 0; i < N; i++) {
				int a = sc.nextInt()-1;
				arr[i][a] = 1;
				System.out.println(i + " " + a);
			}
			for(int i = 0; i < N; i++) {
				if(arr[i][i] == 1) {
					vtd[i] = true;
					System.out.println("Á¤´äÀÌ³É " + i);
					answer++;
				} else solve(i, i, -1, 0);
				System.out.println("========================= " + i + " == " + answer);
			}
			
			System.out.println(N-answer);
		}
	}
}
