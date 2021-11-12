import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] arr = new int[W];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;
            for(int j = i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) left = Math.max(arr[j], left);
            }

            for(int j = i+1; j < W; j++) {
                if(arr[i] < arr[j]) right = Math.max(arr[j], right);
            }

            if(left != 0 && right != 0) {
                answer += (Math.min(left, right) - arr[i]);
            }
        }
        System.out.println(answer);
    }
}
