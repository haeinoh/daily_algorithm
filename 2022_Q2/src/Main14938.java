import java.util.Arrays;
import java.util.Scanner;

public class Main14938 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++) arr[i] = sc.nextInt();

        int[][] dist = new int[N+1][N+1];
        for(int[] i: dist) Arrays.fill(i, 987654321);
        for(int i = 0; i < R; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dist[a][b] = c;
            dist[b][a] = c;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int answer = 0;

        for(int i = 1; i <= N; i++) {
            int item = arr[i];
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] != 987654321 && dist[i][j] <= M) {
                    item += arr[j];
                }
            }
            answer = Math.max(answer, item);
        }

        System.out.println(answer);
    }
}
