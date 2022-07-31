import java.util.Scanner;

public class Main11441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            sum[i] = arr[i] + sum[i-1];
        }

        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(sum[b] - sum[a-1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
