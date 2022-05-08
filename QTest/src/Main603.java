import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
    삽입 정렬 (오름차순)
 */
public class Main603 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            int tmp = arr[i];
            int j = 0;
            for(j = i-1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb.toString());
    }
}
