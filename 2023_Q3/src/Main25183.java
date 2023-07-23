import java.util.Scanner;

public class Main25183 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        boolean flag = false;

        int cnt = 1;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) + 1 == str.charAt(i+1) || str.charAt(i) - 1 == str.charAt(i+1)) cnt++;
            else cnt = 1;
            if(cnt == 5) {
                flag = true;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
