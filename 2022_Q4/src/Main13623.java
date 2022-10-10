import java.util.Scanner;

public class Main13623 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a == b && b == c) System.out.println("*");
        else {
            if(a == b && b != c) System.out.println("C");
            else if(a == c && b != c) System.out.println("B");
            else if(b == c && a != b) System.out.println("A");
        }
    }
}
