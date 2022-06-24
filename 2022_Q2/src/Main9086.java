import java.util.Scanner;

public class Main9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int ts = 1; ts <= T; ts++) {
            String str = sc.next();
            System.out.println(String.valueOf(str.charAt(0))+str.charAt(str.length()-1));
        }
    }
}
