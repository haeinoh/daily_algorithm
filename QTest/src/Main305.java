import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main305 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) arr[i] = i+1;

        int answer = 0;
        int start = 0;
        int end = 1;
        int sum = arr[start];

        while(start < N/2) {
            if(sum >= N) sum -= arr[start++];
            else if(end == N/2+1) break;
            else sum += arr[end++];

            if(sum == N) answer++;
        }
        System.out.println(answer);
    }
}
