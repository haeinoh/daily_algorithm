import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main604_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); // cache size
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[S];
        for(int i = 0; i < N; i++) {
            int value  = Integer.parseInt(st.nextToken());
            int tmp = -1;
                for(int j = 0; j < S; j++) { // contains
                    if(arr[j] == value) {
                        tmp = j;
                        break;
                    }
                }
                if(tmp != -1) {
                    for(int k = tmp; k > 0; k--) {
                        arr[k] = arr[k-1];
                    }
                    arr[0] = value;
                } else {
                    for(int k = S-1; k > 0; k--) {
                        arr[k] = arr[k-1];
                    }
                    arr[0] = value;
                }
//            System.out.println(value + " " + Arrays.toString(arr));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb.toString());
    }
}
