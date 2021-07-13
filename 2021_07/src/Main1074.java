import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
    public static int N, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int answer = 0;

        int x = (1 << N) >> 1; // init
        int y = x;

        while(N-- > 0) {
            int quarter =  (1 << N) * (1 << N);
            int move = (1 << N) >> 1;
            if (r < x && c < y) { // 1
                x -= move;
                y -= move;
            } else if (r < x && c >= y) { // 2
                x -= move;
                y += move;
                answer += quarter;
            } else if (r >= x && c < y) { // 3
                x += move;
                y -= move;
                answer += quarter*2;
            } else {
                x += move;
                y += move;
                answer += quarter*3;
            }
        }

        System.out.println(answer);
    }
}
