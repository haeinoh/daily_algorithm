import java.util.Scanner;

public class Main2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if(i < K) max += arr[i];
        }

        int start = 0;
        int end = K;
        int num = max;
        while(true) {
            if(end == N) break;
            num = num+arr[end++]-arr[start++];
            max = Math.max(max, (num));
        }

        System.out.println(max);
    }
}
