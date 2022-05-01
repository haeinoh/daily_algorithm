import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main302 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0;i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int[] brr = new int[M];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0;i < N; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        int aidx = 0;
        int bidx = 0;

        StringBuilder sb = new StringBuilder();
        while(aidx < N && bidx < M) {
            if(arr[aidx] == brr[bidx]) {
                sb.append(arr[aidx]).append(" ");
                aidx++;
                bidx++;
            } else {
                if(arr[aidx] < brr[bidx]) aidx++;
                else bidx++;
            }
        }

        System.out.println(sb.toString());
    }
}
