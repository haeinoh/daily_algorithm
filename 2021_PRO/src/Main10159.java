import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10159 {
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine().trim());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                dist[i][j] = 987654321;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            dist[a][b] = 1;
        }

        for(int mid = 0; mid < N; mid++) {
            for(int start = 0; start < N; start++) {
                for(int end = 0; end < N; end++) {
                    if(dist[start][end] > dist[start][mid] + dist[mid][end]) {
                        dist[start][end] = dist[start][mid] + dist[mid][end];
                    }
                }
            }
        }

        int[] ans = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(dist[i][j] == 987654321 && dist[j][i] == 987654321) ans[i]++;
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
    }
}
