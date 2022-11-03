import java.util.Scanner;

public class Main10178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("You get " + (a/b) + " piece(s) and your dad gets " + (a%b) + " piece(s).");

        }
    }
}
