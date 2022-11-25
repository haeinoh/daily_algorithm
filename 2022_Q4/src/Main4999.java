import java.util.Scanner;

public class Main4999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if(a.compareTo(b) > 0) System.out.println("no");
        else System.out.println("go");
    }
}
