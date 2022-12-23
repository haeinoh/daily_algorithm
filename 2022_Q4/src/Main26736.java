import java.util.Scanner;

public class Main26736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        str = str.replaceAll("A", "");
        System.out.println((len-str.length()) + " : " + str.length());
    }
}
