import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int X = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int T = 1; // 라인
        int base = 1; // 기준 번호

        while(true) {
            if(X >= base && X < base+T) {
                // (분모+1)/(분자-1)
                if(T % 2 == 0) { //라인이 짝수 : 기준 번호가 기준부터 오름차순
                    sb.append((1+(X-base))).append("/").append((T-(X-base)));
                    break;
                } else { // 라인이 홀수 : 기준번호 + T 부터 내림차순
                    int tmp = base + T - 1;
                    sb.append(1+(tmp-X)).append("/").append(T-(tmp-X));
                    break;
                }
            } else {
                base += T;
                T++;
            }
        }

        System.out.println(sb.toString());
    }
}
