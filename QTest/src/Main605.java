import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main605 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // (1) HashSet
        // (2) array sort
        Arrays.sort(arr);

        boolean flag = false;
        for(int i = 0; i < N-1; i++) {
            if(arr[i] == arr[i+1]) {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println("D");
        else System.out.println("U");
    }
}
