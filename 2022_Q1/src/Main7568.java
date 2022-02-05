import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main7568 {
    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int cnt = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(arr[i][1] < arr[j][1] && arr[i][0] < arr[j][0]) cnt++;
            }
            sb.append(cnt).append(" ");
        }
        System.out.println(sb.toString());
    }
}
