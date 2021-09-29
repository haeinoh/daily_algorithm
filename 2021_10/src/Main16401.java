import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16401 {
    public static int N, M, sum, answer;
    public static int[] arr;
    public static void solve() {
        int s = 0;
        int e = sum;
        while(s < e) {
            int mid = (s + e) >> 1;
            System.out.println(mid);
            if(sum/mid == M){
                answer = mid;
                break;
            }
            if(sum/mid < M) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        sum = 0;
        answer = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(answer);
    }
}
