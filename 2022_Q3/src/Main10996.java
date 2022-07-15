import java.util.Scanner;

public class Main10996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = n % 2 == 0 ? n/2 : n/2+1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < tmp; j++) System.out.print("* ");
            System.out.println();
            for(int j = 0; j < n/2; j++) System.out.print(" *");
            System.out.println();
        }
    }
}
