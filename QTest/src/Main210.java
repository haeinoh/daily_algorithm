import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main210 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+2][N+2];
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int cnt = 0;
                for(int k = 0; k < 4; k++) {
                    if(arr[i+dx[k]][j+dy[k]] < arr[i][j]) cnt++;
                }
                if(cnt == 4) answer++;
            }
        }
        System.out.println(answer);
    }
}