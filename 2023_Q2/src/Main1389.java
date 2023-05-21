import java.util.Arrays;
import java.util.Scanner;

public class Main1389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n+1][n+1];

        for(int[] p: dist) Arrays.fill(p, 987654321);

        for(int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i != j && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int min = 987654321;
        int idx = 0;
        for(int i = 1; i <= n; i++) {
            int tmp = 0;
            for(int j = 1; j <= n; j++) {
                if(i != j && dist[i][j] != 987654321) {
                    tmp += dist[i][j];
                }
            }
            if(min > tmp) {
                min = tmp;
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
