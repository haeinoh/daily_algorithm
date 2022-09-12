import java.util.Scanner;

public class Main5054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int[] arr = new int[M];
            int sum = 0;
            int min = 987654321;
            int max = 0;
            for(int j = 0; j < M; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
            }
            sum /= M;
            System.out.println(((max - sum) + (sum - min))*2);
        }
    }
}
