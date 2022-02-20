import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[15][15];
        for(int i = 1; i <= 14; i++) arr[0][i] = i;
        for(int i = 0; i <= 14; i++) arr[i][1] = 1;

        for(int i = 1; i <= 14; i++) {
            for(int j = 2; j <= 14; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            sb.append(arr[K][N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
