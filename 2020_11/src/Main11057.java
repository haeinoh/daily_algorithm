import java.util.Scanner;

public class Main11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int answer = 0;
		int dp[][] = new int[N+1][10];
		if(N == 1) answer = 10;
		else if(N == 2) answer = 55;
		else {
			for(int i = 0; i < 10; i++) {
				dp[1][i] = 1;
				dp[2][i] = i;
			}
			
			for(int i = 3; i <= N; i++) {
				for(int j = 1; j < 10; j++) {
					dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
				}
			}
			
			for(int j = 1; j <= N; j++) {
				for(int i = 0; i < 10; i++) answer += (dp[j][i] % 10007);
			}
		}
		System.out.println(answer % 10007);
	}
}
