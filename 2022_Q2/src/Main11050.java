import java.util.Scanner;

public class Main11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N+1];
        arr[0] = 1;
        for(int i = 1; i <= N; i++) arr[i] = arr[i-1]*i;

        System.out.println(arr[N]/(arr[N-K]*arr[K]));
    }
}
