import java.util.Scanner;

public class Main18698 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            int cnt = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'D') break;
                else cnt++;
            }
            System.out.println(cnt);
        }
    }
}
