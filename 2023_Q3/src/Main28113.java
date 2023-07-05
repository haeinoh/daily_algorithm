import java.util.Scanner;

public class Main28113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        if(B > A) System.out.println("Bus");
        else if(B == A) System.out.println("Anything");
        else System.out.println("Subway");
    }
}
