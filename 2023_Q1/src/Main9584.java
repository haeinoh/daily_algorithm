import java.util.Scanner;

public class Main9584 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int n = sc.nextInt();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            boolean flag = false;
            for (int j = 0; j < tmp.length(); j++) {
                if (str.charAt(j) == '*') continue;
                if (str.charAt(j) != tmp.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                cnt++;
                sb.append(tmp).append("\n");
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
