import java.util.Scanner;

public class Main807 {
    public static int n, r;
    public static int[][] memo;
    public static int DFS(int n, int r) {
        if(memo[n][r] > 0) return memo[n][r];
        if(n == r || r == 0) return 1;
        else return memo[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        memo = new int[35][35];
        System.out.println(DFS(n,r));
    }
}
