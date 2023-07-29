import java.util.Scanner;

public class Main9848 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cur = sc.nextInt();
        int cnt = 0;
        for(int i = 1; i < n; i++) {
            int tmp  = sc.nextInt();
            if(cur - tmp >= k) cnt++;
            cur = tmp;
        }
        System.out.println(cnt);
    }
}
