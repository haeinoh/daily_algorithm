import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N+1][N+1];
        for(int[] p: dist) Arrays.fill(p, 987654321);
        while(true) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int[] answer = new int[N+1];
        int min = 987654321;
        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                if(i != j) {
                    answer[i] = Math.max(answer[i], dist[i][j]);
                }
            }
            min = Math.min(min, answer[i]);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(min == answer[i]) {
                count++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(min + " " + count);
        System.out.println(sb.toString());
    }
}
