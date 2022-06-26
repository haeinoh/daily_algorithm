import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2458_Buffered {
    public static int N, M;
    public static int[][] dist;
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];

        for(int[] i : dist) Arrays.fill(i, INF);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    if(dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] != INF || dist[j][i] != INF) cnt++;
            }
            if(cnt == N-1) answer++;
        }

        System.out.println(answer);
    }
}
