import java.util.Scanner;

public class Main10156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a*b >= c) System.out.println(a*b - c);
        else System.out.println("0");
    }
}
