import java.util.Scanner;

public class Main10480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(tmp % 2 == 0) System.out.println(tmp + " is even");
            else System.out.println(tmp + " is odd");
        }
    }
}
