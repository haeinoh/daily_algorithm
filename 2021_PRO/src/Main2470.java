import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int sum = 2000000000;
        int min = 0;
        int max = 0;
        while(start < end) {
            int abs = Math.abs(arr[start] + arr[end]);
            if(abs < sum) {
                sum = abs;
                min = arr[start];
                max = arr[end];
            }
            if(arr[start] + arr[end] > 0) end--; // end 값  > start 값 : 합이 커서 줄여야함
            else start++; // start > end : 합이 작아서 늘려야함
        }
        System.out.println(min + " " +max);
    }
}
