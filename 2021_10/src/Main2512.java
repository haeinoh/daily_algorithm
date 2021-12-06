import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2512 {
    public static int N, M, answer;
    public static int[] arr;

    public static boolean check(int value) {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            if(value - arr[i] >= 0) sum += arr[i];
            else sum += value;
        }
        if(sum > M) return false;
        else answer = Math.max(answer, value);
        return true;
    }
    public static void solve() {
        int start = 0;
        int end = arr[N-1];

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(check(mid)) start = mid + 1;
            else end = mid - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        answer = 0;
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());

        solve();

        System.out.println(answer);
    }
}
