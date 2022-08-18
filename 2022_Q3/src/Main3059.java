import java.util.Scanner;

public class Main3059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int ts = 1; ts <= T; ts++) {
            String s = sc.next();
            boolean[] vtd = new boolean[26];
            int cnt = 0;
            for(int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                vtd[(int)ch-65] = true;
            }
            for(int i = 0; i < vtd.length; i++) {
                if(!vtd[i]) cnt += (i+65);
            }
            System.out.println(cnt);
        }
    }
}
