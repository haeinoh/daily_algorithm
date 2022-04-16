import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main206_1 {
    public static boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken()).reverse();
            int tmp = Integer.parseInt(sb.toString());
            if(isPrime(tmp)) ans.append(tmp).append(" ");
        }
        System.out.println(ans.toString());
    }
}
