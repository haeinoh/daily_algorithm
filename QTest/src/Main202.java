import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main202 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int prev = arr[0];
        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(prev < arr[i]) {
                cnt++;
                prev = arr[i];
            }
        }

        System.out.println(cnt);
    }
}
