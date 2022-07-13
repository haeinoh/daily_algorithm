import java.util.Scanner;

public class Main14490 {
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split(":");
        int num = gcd(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        System.out.println((Integer.parseInt(str[0])/num) + ":" + (Integer.parseInt(str[1])/num));
    }
}
