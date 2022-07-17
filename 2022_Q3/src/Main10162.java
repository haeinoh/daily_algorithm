import java.util.Scanner;

public class Main10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = n/300;
        int tmp = n%300;
        int b = tmp/60;
        tmp = tmp % 60;
        int c = tmp/10;
        if(tmp % 10 != 0) System.out.println("-1");
        else System.out.println(a + " " + b + " " + c);
    }
}
