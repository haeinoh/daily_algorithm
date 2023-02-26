import java.util.Scanner;

public class Main15178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.print(a + " " + b + " " + c + " ");
            if(a+b+c == 180) System.out.println("Seems OK");
            else System.out.println("Check");
        }
    }
}
