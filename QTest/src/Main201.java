import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main201 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");
        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > arr[i-1]) sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
