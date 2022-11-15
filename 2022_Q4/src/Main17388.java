import java.util.Scanner;

public class Main17388 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a + b + c >= 100) System.out.println("OK");
        else {
            if(a < b && a < c) System.out.println("Soongsil");
            else if(b < c && b < a) System.out.println("Korea");
            else System.out.println("Hanyang");
        }
    }
}
