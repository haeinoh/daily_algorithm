
import java.util.Scanner;

public class Main9095 {
	public static int N, K, arr[];

	public static void solve() {
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i = 4; i < 11; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
	}
	public static void main(String[] args){
		arr = new int[11];
		solve();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			K = sc.nextInt();
			System.out.println(arr[K]);
		}
	}
}
