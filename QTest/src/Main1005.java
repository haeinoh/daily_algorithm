import java.util.Arrays;
import java.util.Scanner;

public class Main1005 {
    public static int N, M;
    public static int[] coin, memo;
    public static int solve() {
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for(int i = 0; i < N; i++) {
            for(int j = coin[i]; j <= M; j++) {
                memo[j] = Math.min(memo[j], memo[j-coin[i]]+1);
            }
        }
        return memo[M];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coin = new int[N];
        for(int i = 0; i < N; i++) coin[i] = sc.nextInt();
        M = sc.nextInt();
        memo = new int[M+1];
        System.out.println(solve());
    }
}
