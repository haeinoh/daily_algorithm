import java.util.Scanner;

public class Main11051 {
    public static int[][] arr;
    public static int solve(int n, int k) {
        if(arr[n][k] > 0) return arr[n][k];

        if(k == 0 || n == k) return arr[n][k] = 1;

        return arr[n][k] = (solve(n-1, k) + solve(n-1, k-1)) % 10007;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        arr = new int[N+1][K+1];
        System.out.println(solve(N, K));
    }
}