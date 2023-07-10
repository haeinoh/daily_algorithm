import java.util.Scanner;

public class Main26531 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String tmp = sc.next();
        int b = sc.nextInt();
        String tmp2 = sc.next();
        int c = sc.nextInt();
        if(a + b == c) System.out.println("YES");
        else System.out.println("NO");
    }
}
