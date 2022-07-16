import java.util.Scanner;

public class Main10870 {
    public static int fibo(int n) {
        if(n == 1 || n == 2) return 1;
        else return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0) System.out.println(n);
        else System.out.println(fibo(n));
    }
}
