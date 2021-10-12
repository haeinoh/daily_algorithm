import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] answer = new int[2];
        int number = 2000000000;

        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int abs = Math.abs(arr[start] + arr[end]);
            if(number > abs){
                answer[0] = arr[start];
                answer[1] = arr[end];
                number = abs;
            }
            if(arr[start] + arr[end] > 0) end--;
            else start++;
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
