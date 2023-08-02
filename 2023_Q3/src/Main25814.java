import java.util.Scanner;

public class Main25814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int asum = 0;
        int bsum = 0;

        for(int i = 0; i < a.length(); i++) {
            asum += Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        for(int i = 0; i < b.length(); i++) {
            bsum += Integer.parseInt(String.valueOf(b.charAt(i)));
        }
        asum *= a.length();
        bsum *= b.length();
        if(asum > bsum) System.out.println("1");
        else if(asum < bsum) System.out.println("2");
        else System.out.println("0");
    }
}
