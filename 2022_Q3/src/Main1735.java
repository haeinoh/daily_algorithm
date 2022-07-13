import java.util.Scanner;

public class Main1735 {
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int ja = d*a + c*b;
        int mo = b*d;
        int gcdRes = gcd(ja, mo);
        System.out.println((ja/gcdRes) + " " + (mo/gcdRes));
    }
}
