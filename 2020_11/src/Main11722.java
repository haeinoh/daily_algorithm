import java.util.Scanner;

public class Main11722 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
//				if(arr[i] < arr[j] && dp[i] < dp[j] + 1) {
//					dp[i] = dp[j] + 1;
//				}
			}
		}
		int answer = dp[0];
		for(int i = 1; i < N; i++) answer = Math.max(answer, dp[i]);
		System.out.println(answer);
	}
}
