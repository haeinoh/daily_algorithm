import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main304_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int sum = 0;
        int answer = 0;
        for(int end = 0; end < N; end++) {
            sum += arr[end];
            if(sum == M) answer++;
            while(sum >= M) {
                sum -= arr[start++];
                if(sum == M) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
