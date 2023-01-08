import java.util.Scanner;

public class Main2495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            String str = sc.next();
            int max = 0;
            int cnt = 1;
            int prev = str.charAt(0) - 48;;
            for(int j = 1; j < str.length(); j++) {
                int val = str.charAt(j) - 48;
                if(prev == val) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        max = Math.max(cnt, max);
                    }
                    prev = val;
                    cnt = 1;
                }
            }
            if(cnt > 1) {
                max = Math.max(cnt, max);
            }
            if(max == 0) System.out.println("1");
            else System.out.println(max);
        }
    }
}
