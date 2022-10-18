import java.util.Scanner;

public class Main10987 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();

        str = str.replaceAll("a", "");
        str = str.replaceAll("e", "");
        str = str.replaceAll("i", "");
        str = str.replaceAll("o", "");
        str = str.replaceAll("u", "");

        System.out.println(len - str.length());
    }
}
