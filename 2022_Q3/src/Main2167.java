import java.util.Scanner;

public class Main2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int K = sc.nextInt();
        for(int i = 0; i < K; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;

            int sum = 0;
            for(int j = x; j <= a; j++) {
                for(int k = y; k <= b; k++) {
                    sum += arr[j][k];
                }
            }
            System.out.println(sum);
        }

    }
}
