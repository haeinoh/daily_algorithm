import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1026 {
    public static int N, answer;
    public static int[] arr, brr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        answer = 0;

        arr = new int[N];
        brr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) brr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        Arrays.sort(brr);

        for(int i = 0; i < N; i++) answer += (arr[N-i-1] * brr[i]);


        System.out.println(answer);
    }
}
