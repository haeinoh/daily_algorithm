import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[N];
        int[] vtd = new int[d+1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //init
        int count = 0;
        for(int i = 0; i < k; i++) {
            vtd[arr[i]]++;
            if(vtd[arr[i]] == 1) count++;
        }
        int cnt = count;
        if(vtd[c] == 0) count++;
        for(int i = k; i < N+k-1; i++){
            if(--vtd[arr[(i-k)%N]] == 0) cnt--;
            if(++vtd[arr[i%N]] == 1) cnt++;
            count = Math.max(vtd[c] == 0 ? cnt+1 : cnt, count);
        }

        System.out.println(count);
    }
}
