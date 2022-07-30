import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(j == 1) sum[i][j] = arr[i][j] + sum[i-1][N];
                else sum[i][j] = arr[i][j] + sum[i][j-1];
            }
        }

//        for(int p[]: sum)
//            System.out.println(Arrays.toString(p));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = 0;
            if(x1 == x2) {
                if(y1 == 1) ans = sum[x2][y2] - sum[x1-1][N];
                else ans = sum[x2][y2] - sum[x1][y1-1];
            } else {
                if(y1 == 1) ans = sum[x2][y2] - sum[x1-1][N] - (sum[x2][y1-1] - sum[x1-1][y2]);
                else ans = sum[x2][y2] - sum[x1][y1-1] - (sum[x2][y1-1] - sum[x1][y2]);
            }
            sb.append(ans).append("\n");
        }


        System.out.println(sb.toString());
    }
}
