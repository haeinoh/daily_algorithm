import java.util.Scanner;

public class Main11404 {
    public static int N, M;
    public static int[][] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N][N];
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();

            if(dist[a][b] != 0) dist[a][b] = Math.min(dist[a][b], c);
            else dist[a][b] = c;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(dist[i][j] == 0) dist[i][j] = 987654321;
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j) {
                        dist[i][j] = 0;
                        continue;
                    }
//                    if(dist[j][k] == 0 || dist[k][j] == 0) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(dist[i][j] == 987654321) sb.append("0");
                else sb.append(dist[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
