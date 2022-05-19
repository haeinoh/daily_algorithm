import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main805 {
    public static int N, M, answer;
    public static Integer[] arr;
    public static void DFS(int cnt, int sum) {
        if(sum > M || answer <= cnt) return;
        if(sum == M) {
            answer = Math.min(answer, cnt);
        } else {
            for(int i = 0; i < N; i++) {
                DFS(cnt+1, sum+arr[i]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        Arrays.sort(arr, Collections.reverseOrder());
        DFS(0, 0);

        System.out.println(answer);
    }
}
