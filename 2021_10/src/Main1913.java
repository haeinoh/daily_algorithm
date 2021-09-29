import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine().trim());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int num = N*N;

        for(int p = 0; p < N/2; p++) {
            for(int i = p; i < N-p; i++) { // down
                arr[i][p] = num--;
            }

            for(int i = p+1; i < N-p; i++) { // right
                arr[N-p-1][i] = num--;
            }

            for(int i = N-p-2; i >= p; i--) { // up
                arr[i][N-p-1] = num--;
            }

            for(int i = N-p-2; i > p; i--) { // left;
                arr[p][i] = num--;
            }
        }
        arr[N/2][N/2] = 1;

        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == M) ans.append(i+1).append(" ").append(j+1);
            }
            if(i != N-1) sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println(ans.toString());
    }
}
