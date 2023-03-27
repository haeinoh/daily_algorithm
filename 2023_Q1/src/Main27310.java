import java.util.Scanner;

public class Main27310 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        str = str.replaceAll(":", "");
        int newLen = str.length();
        int clone = len - newLen;
        str = str.replaceAll("_", "");
        int underbar = newLen - str.length();

        System.out.println(len + clone + underbar*5);
    }
}
