import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816_LowerboundUpperbound {
    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb;
    public static int upperbound(int num) {
        int start = 0;
        int end = arr.length;
        while(start < end) {
            int mid = (start + end) >> 1;
            if(arr[mid] > num) end = mid;
            else start = mid + 1;
        }
        return start;
    }
    public static int lowerbound(int num) {
        int start = 0;
        int end = arr.length;
        while(start < end) {
            int mid = (start + end) >> 1;
            if(arr[mid] >= num) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        st = new StringTokenizer(bf.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int up = upperbound(num);
            if(up < 0) sb.append("0").append(" ");
            else sb.append(up - lowerbound(num)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
