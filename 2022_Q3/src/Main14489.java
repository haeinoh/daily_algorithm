import java.util.Scanner;

public class Main14489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int chicken = sc.nextInt();
        if(a + b >= chicken*2) System.out.println((a+b) - (chicken*2));
        else System.out.println(a+b);
    }
}
