import java.util.Arrays;
import java.util.Scanner;

public class Main6359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int ts = 1; ts <= T; ts++) {
            int N = sc.nextInt();

            boolean[] arr = new boolean[N+1];

            for(int i = 2; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(j % i == 0) {
                        if(!arr[j]) arr[j] = true;
                        else arr[j] = false;
                    }
                }
            }

            int cnt = 0;
            for(int i = 1; i <= N; i++) if(!arr[i]) cnt++;

            System.out.println(cnt);
        }
    }
}
