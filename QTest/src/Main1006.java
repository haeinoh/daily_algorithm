import java.util.Scanner;

public class Main1006 {
    public static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[] memo = new int[M+1];
        for(int i = 0; i < N; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for(int j = M; j >= pt; j--) {
                memo[j] = Math.max(memo[j], memo[j-pt]+ps);
            }
        }
        System.out.println(memo[M]);
    }
}
