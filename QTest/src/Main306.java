import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main306 {

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

        int answer = 0;
        int cnt = 0;
        int left = 0;
        int right = 0;

        while(right < N) {
            if(arr[right] == 0) cnt++;
            if(cnt > M) {
                if(arr[left] == 0) cnt--;
                left++;
            }
            answer = Math.max(answer, (right-left+1));
            right++;
        }

        System.out.println(answer);
    }
}
