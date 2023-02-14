import java.util.Scanner;

public class Main5555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int n = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            tmp += tmp;
            if(tmp.contains(str)) cnt++;
        }
        System.out.println(cnt);
    }
}
