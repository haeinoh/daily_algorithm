import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main205 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        int answer = 0;

        boolean[] vtd = new boolean[N+1];
        for(int i = 2; i <= N; i++) {
            if(vtd[i]) continue;
            else answer++;
            for(int j = i; j <= N; j+=i) {
                vtd[j] = true;
            }
        }
        System.out.println(answer);
    }
}