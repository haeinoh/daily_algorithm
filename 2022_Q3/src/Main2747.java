import java.util.Scanner;

public class Main2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long prev = 1;
        long prevprev = 1;
        long num = 0;
        for(int i = 3; i <= n; i++) {
            num = prev + prevprev;
            prevprev = prev;
            prev = num;
        }

        if(n == 0) System.out.println("0");
        else if(n == 1 || n == 2) System.out.println("1");
        else System.out.println(num);
    }
}
