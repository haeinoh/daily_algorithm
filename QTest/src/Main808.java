import java.util.Arrays;
import java.util.Scanner;

public class Main808 {
    public static int N, F;
    public static int[] comb, permutation, ch;
    public static boolean flag = false;
    public static int[][] memo = new int[35][35];
    public static int combination (int n, int r) {
        if(memo[n][r] > 0) return memo[n][r];
        if(n == r || r == 0) return 1;
        else return memo[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
    public static void DFS(int cnt, int sum) {
        if(flag) return;
        if(N == cnt) {
            if(sum == F) {
                for(int x : permutation) System.out.print(x +" ");
                System.out.println();
                flag = true;
            }
        } else {
            for(int i = 1; i <= N; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    permutation[cnt] = i;
                    DFS(cnt + 1, sum + (permutation[cnt] * comb[cnt]));
                    ch[i] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = sc.nextInt();
        comb = new int[N];
        permutation = new int[N];
        ch = new int[N+1];
        for(int i = 0; i < N; i++) comb[i] = combination(N-1, i);

        DFS(0,0 );
    }
}
