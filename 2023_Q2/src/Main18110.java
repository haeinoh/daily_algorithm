import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int v = (int)Math.round(n*0.15);

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for(int i = v; i < n-v; i++) sum += arr[i];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Math.round(sum/(double)(n-v*2))+" ");
        bw.flush();
        bw.close();
    }
}
