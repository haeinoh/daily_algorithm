import java.util.Scanner;

public class Main2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];
        for(int k = 0; k < 2; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0 ; j < M; j++) {
                    arr[i][j] += sc.nextInt();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
