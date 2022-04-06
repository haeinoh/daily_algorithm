import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main301 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] brr = new int[M];
        st = new StringTokenizer(bf.readLine());
        for(int j = 0; j < M; j++) {
            brr[j] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N+M];
        int idx = 0;
        int aidx = 0;
        int bidx = 0;
        for(int i = 0; i < N+M; i++) {
            int atmp = 0;
            int btmp = 0;
            if(aidx < N) {
                atmp = arr[aidx];
            }
            if(bidx < M) {
                btmp = brr[bidx];
            }
            if(aidx< N && bidx < M) {
                if(atmp < btmp) {
                    answer[idx] = atmp;
                    aidx++;
                } else {
                    answer[idx] = btmp;
                    bidx++;
                }
            } else if(aidx < N) {
                answer[idx] = atmp;
                aidx++;
            } else {
                answer[idx] = btmp;
                bidx++;
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N+M; i++) sb.append(answer[i]).append(" ");
        System.out.println(sb.toString());
    }
}
