import java.util.Scanner;

public class Main5176 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for(int t = 0; t < K; t++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int cnt = 0;
            boolean[] vtd = new boolean[m];
            for(int i = 0; i < p; i++) {
                int value = sc.nextInt()-1;
                if(vtd[value]) cnt++;
                vtd[value] = true;
            }
            System.out.println(cnt);
        }
    }
}
