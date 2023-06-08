import java.util.Scanner;

public class Main1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        long ans = 0;
        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++) {
                ans += Integer.parseInt(String.valueOf(a.charAt(i)))*Integer.parseInt(String.valueOf(b.charAt(j)));
            }
        }

        System.out.println(ans);
    }
}
