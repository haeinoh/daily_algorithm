import java.util.Arrays;
import java.util.Scanner;

public class Main14501 {
	public static int N, time[], price[], dp[], answer;
	
	public static void solve() {
		
		for(int i = N-1; i >= 0 ;i--) {
			
			
		}
 		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N];
		price = new int[N];
		dp = new int[N];
		answer = 0;
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			time[i] = x;
			price[i] = y;
		}
		solve();
		System.out.println(answer);
	}
}
