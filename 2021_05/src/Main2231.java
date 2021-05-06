import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2231 {
    public static int N;

    public static int solve(int num) {
        int answer = num;
        while(num > 0) {
            answer += num % 10;
            num /= 10;
        }
        return answer;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i = N/2; i <= N; i++) {
            if(N == solve(i)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
