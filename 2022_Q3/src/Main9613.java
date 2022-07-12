import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9613 {
    public static long sum;
    public static long gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    public static void brute(String[] arr, boolean[] vtd, int[] tmp, int cnt, int prev) {
        if(cnt == 2) {
            sum += gcd(tmp[0], tmp[1]);
            return;
        }
        for(int i = prev; i < arr.length; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                tmp[cnt] = Integer.parseInt(arr[i]);
                brute(arr, vtd, tmp,cnt+1, i);
                vtd[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String[] arr = bf.readLine().split(" ");
            sum = 0L;
            brute(arr, new boolean[arr.length],new int[2], 0, 1);
            System.out.println(sum);
        }

    }
}
