//https://www.acmicpc.net/problem/3649
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3649 {
    public static int N;
    public static long X, arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while((temp = bf.readLine())!= null) {
            StringTokenizer st = new StringTokenizer(temp.trim());
            X = Long.parseLong(st.nextToken())*10000000; // cm -> nano meter
            st = new StringTokenizer(bf.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            arr = new long[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine().trim());
                arr[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(arr);
            boolean flag = false;
            if(N > 1) {
                int start = 0;
                int end = arr.length-1;
                while(start < end) {
                    if(X == arr[start] + arr[end]) {
                        System.out.println("yes " + arr[start] + " " + arr[end]);
                        flag = true;
                        break;
                    }
                    else if(arr[start] + arr[end] > X) end--;
                    else start++;
                }
            }
            if(!flag) System.out.println("danger");
        }
    }
}
