import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2108_Buffered_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[8001];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int value = Integer.parseInt(st.nextToken());
            sum += value;
            min = Math.min(min, value);
            max = Math.max(max, value);
            arr[value+4000]++;
        }

        int freq = 0;
        int cnt = 0;
        int mid = 0;
        int freqNum = Integer.MIN_VALUE;
        boolean flag = false;

        for(int i = min+4000; i <= max + 4000; i++) {
            if(arr[i] > 0) {
                if(cnt < (N+1)/2) {
                    cnt += arr[i]; // 빈도수니깐,,, 갯수 세려면 빈도수를 입력해야함
                    mid = i - 4000;
                }

                if(freqNum < arr[i]) {
                    freqNum = arr[i];
                    freq = i - 4000;
                    flag = true;
                } else if(freqNum == arr[i] && flag) {
                    freq = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println(Math.round(((sum)/(double)N)*10/10.0));
        System.out.println(mid);
        System.out.println(freq);
        System.out.println(max - min);
    }
}
