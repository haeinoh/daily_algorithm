import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main204 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i < N; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb.toString());
    }
}
