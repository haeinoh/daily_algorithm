import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main11404_Buffered {
    public static int N, M;
    public static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

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
