import java.util.Scanner;

public class Main20361 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == x) x = b;
            else if(b == x) x = a;
        }
        System.out.println(x);
    }
}
