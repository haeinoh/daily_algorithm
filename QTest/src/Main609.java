import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main609 {
    public static int count(int[] arr, int cap) {
        int cnt = 1, sum = 0;
        for(int x: arr) {
            if(sum+x > cap){
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }
    public static int solve(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); //optionalInt라서 getAsInt()
        int rt = Arrays.stream(arr).sum();

        while(lt <= rt) {
            int mid = (lt + rt) >> 1;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid -1;
            } else lt = mid + 1;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solve(N, M, arr));
    }
}
