import java.util.Scanner;

public class Main15917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int n = sc.nextInt();
            if((n&(-n)) == n) System.out.println("1");
            else System.out.println("0");
        }
    }
}
