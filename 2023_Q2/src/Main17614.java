import java.util.Scanner;

public class Main17614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++) {
            String tmp = String.valueOf(i);
            int len = tmp.length();
            tmp = tmp.replaceAll("3", "");
            tmp = tmp.replaceAll("6", "");
            tmp = tmp.replaceAll("9", "");
            count += (len - tmp.length());
        }
        System.out.println(count);
    }
}
